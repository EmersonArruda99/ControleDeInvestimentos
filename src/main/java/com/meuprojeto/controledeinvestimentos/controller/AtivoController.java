package com.meuprojeto.controledeinvestimentos.controller;

import com.meuprojeto.controledeinvestimentos.DTO.AtivoRequestDTO;
import com.meuprojeto.controledeinvestimentos.DTO.AtivoResponseDTO;
import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import com.meuprojeto.controledeinvestimentos.utils.AtivoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    private AtivoRepository ativoRepository;

    @PostMapping
    public AtivoResponseDTO criar(@RequestBody @Valid AtivoRequestDTO dto) {
        Ativo ativo = AtivoMapper.toEntity(dto);
        ativo = ativoRepository.save(ativo);
        return AtivoMapper.toDTO(ativo);
    }

    @GetMapping
    public List<AtivoResponseDTO> listar() {
        return ativoRepository.findAll()
                .stream()
                .map(AtivoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AtivoResponseDTO buscarPorId(@PathVariable Long id) {
        Ativo ativo = ativoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado"));
        return AtivoMapper.toDTO(ativo);
    }

    @PutMapping("/{id}")
    public AtivoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid AtivoRequestDTO dto) {
        Ativo ativo = ativoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado"));

        AtivoMapper.updateEntity(ativo, dto);
        ativo = ativoRepository.save(ativo);

        return AtivoMapper.toDTO(ativo);
    }


}
