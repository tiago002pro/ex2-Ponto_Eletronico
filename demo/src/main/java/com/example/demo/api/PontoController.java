package com.example.demo.api;

import com.example.demo.model.Ponto;
import com.example.demo.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PontoController {

    @Autowired
    PontoService service;

    @PostMapping("/ponto")
    public String registraPonto(@RequestBody Map<String, Object> json) {
        return this.service.registraPonto(json);
    }

    @GetMapping("/ponto/funcionarios")
    public List<Ponto> getPontos() {
        return this.service.getPontos();
    }

    @PostMapping("/ponto/desbloqueio/funcionario")
    public String desbloqueiaFuncionario (@RequestBody Map<String, Object> json) {
        return this.service.desbloqueiaFuncionario(json);
    }
}