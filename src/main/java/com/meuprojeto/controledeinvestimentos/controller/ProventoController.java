package com.meuprojeto.controledeinvestimentos.controller;

import com.meuprojeto.controledeinvestimentos.DTO.ProventoRequestDTO;
import com.meuprojeto.controledeinvestimentos.DTO.ProventoResponseDTO;
import com.meuprojeto.controledeinvestimentos.service.ProventoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proventos")
public class ProventoController {

    private final ProventoService proventoService;

    public ProventoController(ProventoService proventoService) {
        this.proventoService = proventoService;
    }

    @PostMapping
    public ProventoResponseDTO criarProvento(@RequestBody @Valid ProventoRequestDTO dto) {
        return proventoService.criarProvento(dto);
    }

    @GetMapping
    public List<ProventoResponseDTO> listarProventos() {
        return proventoService.listarProventos();
    }

    @GetMapping("/{id}")
    public ProventoResponseDTO buscarPorId(@PathVariable Long id) {
        return proventoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        proventoService.deletarPorId(id);
    }

}