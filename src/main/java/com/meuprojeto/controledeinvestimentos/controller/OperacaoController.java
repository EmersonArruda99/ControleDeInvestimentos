package com.meuprojeto.controledeinvestimentos.controller;

import com.meuprojeto.controledeinvestimentos.DTO.OperacaoRequestDTO;
import com.meuprojeto.controledeinvestimentos.DTO.OperacaoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.model.Operacao;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import com.meuprojeto.controledeinvestimentos.repository.OperacaoRepository;
import com.meuprojeto.controledeinvestimentos.utils.OperacaoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private AtivoRepository ativoRepository;

    @PostMapping
    public OperacaoResponseDTO criarOperacao(@RequestBody @Valid OperacaoRequestDTO dto) {
        Ativo ativo = ativoRepository.findById(dto.getAtivoId())
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado com ID: " + dto.getAtivoId()));

        Operacao operacao = new Operacao();
        operacao.setTipo(dto.getTipo());
        operacao.setData(dto.getData());
        operacao.setQuantidade(dto.getQuantidade());
        operacao.setPrecoUnitario(dto.getPrecoUnitario());
        operacao.setCorretagem(dto.getCorretagem());
        operacao.setAtivo(ativo);

        operacao = operacaoRepository.save(operacao);

        // Converter para DTO de resposta
        OperacaoResponseDTO response = new OperacaoResponseDTO();
        response.setId(operacao.getId());
        response.setTipo(operacao.getTipo());
        response.setData(operacao.getData());
        response.setQuantidade(operacao.getQuantidade());
        response.setPrecoUnitario(operacao.getPrecoUnitario());
        response.setCorretagem(operacao.getCorretagem());
        response.setTotal(operacao.getTotal());

        response.setAtivoId(ativo.getId());
        response.setTicker(ativo.getTicker());
        response.setNome(ativo.getNome());
        response.setTipoAtivo(ativo.getTipo());
        response.setSetor(ativo.getSetor());

        return OperacaoMapper.toDTO(operacao);

    }

    @GetMapping
    public List<OperacaoResponseDTO> listarOperacoes() {
        return operacaoRepository.findAll()
                .stream()
                .map(OperacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OperacaoResponseDTO buscarPorId(@PathVariable Long id) {
        Operacao operacao = operacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Operação não encontrada"));

        return OperacaoMapper.toDTO(operacao);
    }


}
