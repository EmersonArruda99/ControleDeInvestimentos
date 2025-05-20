package com.meuprojeto.controledeinvestimentos.controller;

import com.meuprojeto.controledeinvestimentos.model.Ativo;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    private AtivoRepository ativoRepository;

    @PostMapping
    public Ativo criarAtivo(@RequestBody Ativo ativo){
        return ativoRepository.save(ativo);
    }

    @GetMapping
    public List<Ativo> listarAtivos(){
        return ativoRepository.findAll();
    }
}
