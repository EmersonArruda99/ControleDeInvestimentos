package com.meuprojeto.controledeinvestimentos.service;

import com.meuprojeto.controledeinvestimentos.DTO.ProventoRequestDTO;
import com.meuprojeto.controledeinvestimentos.DTO.ProventoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.model.Provento;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import com.meuprojeto.controledeinvestimentos.repository.ProventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProventoService {

    private final ProventoRepository proventoRepository;
    private final AtivoRepository ativoRepository;

    public ProventoService(ProventoRepository proventoRepository, AtivoRepository ativoRepository) {
        this.proventoRepository = proventoRepository;
        this.ativoRepository = ativoRepository;
    }

    public ProventoResponseDTO criarProvento(ProventoRequestDTO dto) {
        Ativo ativo = ativoRepository.findById(dto.ativoId())
                .orElseThrow(() -> new IllegalArgumentException("Ativo não encontrado"));

        Provento provento = Provento.builder()
                .ativo(ativo)
                .tipo(dto.tipo())
                .dataPagamento(dto.dataPagamento())
                .valorPorCota(dto.valorPorCota())
                .quantidade(dto.quantidade())
                .valorRecebido(dto.valorRecebido())
                .build();

        provento = proventoRepository.save(provento);

        return new ProventoResponseDTO(
                provento.getId(),
                ativo.getId(),
                ativo.getTicker(),
                provento.getTipo(),
                provento.getDataPagamento(),
                provento.getValorPorCota(),
                provento.getQuantidade(),
                provento.getValorRecebido()
        );
    }

    public List<ProventoResponseDTO> listarProventos() {
        return proventoRepository.findAll().stream()
                .map(provento -> new ProventoResponseDTO(
                        provento.getId(),
                        provento.getAtivo().getId(),
                        provento.getAtivo().getTicker(),
                        provento.getTipo(),
                        provento.getDataPagamento(),
                        provento.getValorPorCota(),
                        provento.getQuantidade(),
                        provento.getValorRecebido()
                ))
                .collect(Collectors.toList());
    }

    public ProventoResponseDTO buscarPorId(Long id) {
        Provento provento = proventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Provento não encontrado"));

        return new ProventoResponseDTO(
                provento.getId(),
                provento.getAtivo().getId(),
                provento.getAtivo().getTicker(),
                provento.getTipo(),
                provento.getDataPagamento(),
                provento.getValorPorCota(),
                provento.getQuantidade(),
                provento.getValorRecebido()
        );
    }

    public void deletarPorId(Long id) {
        if (!proventoRepository.existsById(id)) {
            throw new IllegalArgumentException("Provento não encontrado");
        }
        proventoRepository.deleteById(id);
    }
}