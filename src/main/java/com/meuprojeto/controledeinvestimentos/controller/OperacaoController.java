package com.meuprojeto.controledeinvestimentos.controller;

import com.meuprojeto.controledeinvestimentos.model.Operacao;
import com.meuprojeto.controledeinvestimentos.repository.AtivoRepository;
import com.meuprojeto.controledeinvestimentos.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private AtivoRepository ativoRepository;

    @PostMapping
    public Operacao criarOperacao(@RequestBody Operacao operacao){
        return operacaoRepository.save(operacao);
    }

    @GetMapping
    public List<Operacao> listarOperacoes(){
        return operacaoRepository.findAll();
    }
}
