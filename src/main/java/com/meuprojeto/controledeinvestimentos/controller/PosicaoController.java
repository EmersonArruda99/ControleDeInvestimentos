package com.meuprojeto.controledeinvestimentos.controller;


import com.meuprojeto.controledeinvestimentos.DTO.PosicaoResponseDTO;
import com.meuprojeto.controledeinvestimentos.service.PosicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posicao")
@RequiredArgsConstructor
public class PosicaoController {

    private final PosicaoService posicaoService;

    @GetMapping("/{ativoId}")
    public ResponseEntity<PosicaoResponseDTO> consultarPosicao(@PathVariable Long ativoId) {
        PosicaoResponseDTO posicao = posicaoService.calcularPosicao(ativoId);
        return ResponseEntity.ok(posicao);
    }

    @GetMapping
    public ResponseEntity<List<PosicaoResponseDTO>> consultarTodasPosicoes() {
        List<PosicaoResponseDTO> posicoes = posicaoService.calcularTodasPosicoes();
        return ResponseEntity.ok(posicoes);
    }
}