package com.meuprojeto.controledeinvestimentos.service;

import com.meuprojeto.controledeinvestimentos.DTO.PosicaoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.model.Operacao;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import com.meuprojeto.controledeinvestimentos.repository.OperacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PosicaoService {

    private final OperacaoRepository operacaoRepository;
    private final AtivoRepository ativoRepository;

    public PosicaoResponseDTO calcularPosicao(Long ativoId) {
        Ativo ativo = ativoRepository.findById(ativoId)
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        List<Operacao> operacoes = operacaoRepository.findByAtivoId(ativoId);

        int quantidade = operacoes.stream()
                .mapToInt(Operacao::getQuantidade)
                .sum();

        BigDecimal valorInvestido = operacoes.stream()
                .map(op -> op.getPrecoUnitario().multiply(BigDecimal.valueOf(op.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCorretagem = operacoes.stream()
                .map(Operacao::getCorretagem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal precoMedio = quantidade > 0 ?
                valorInvestido.divide(BigDecimal.valueOf(quantidade), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        return PosicaoResponseDTO.builder()
                .ativoId(ativo.getId())
                .ticker(ativo.getTicker())
                .quantidade(quantidade)
                .valorInvestido(valorInvestido)
                .totalCorretagem(totalCorretagem)
                .precoMedio(precoMedio)
                .build();
    }

    public List<PosicaoResponseDTO> calcularTodasPosicoes() {
        return ativoRepository.findAll().stream()
                .filter(ativo -> !operacaoRepository.findByAtivoId(ativo.getId()).isEmpty())
                .map(ativo -> calcularPosicao(ativo.getId()))
                .collect(Collectors.toList());
    }
}