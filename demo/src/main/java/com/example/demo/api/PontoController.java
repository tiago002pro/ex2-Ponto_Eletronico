package com.example.demo.api;

import com.example.demo.model.Ponto;
import com.example.demo.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PontoController {

    @Autowired
    PontoService service;

    @PostMapping("/ponto-registro/funcionario/{id_funcionario}")
    public String registraPonto(@PathVariable Long id_funcionario) {
        return this.service.registraPonto(id_funcionario);
    }

    @GetMapping("/ponto-registro/funcionarios")
    public List<Ponto> getPontos() {
        return this.service.getPontos();
    }

    @PostMapping("/ponto-desbloqueio/funcionario/{id_funcionario}")
    public String desbloqueiaFuncionario (@PathVariable Long id_funcionario, @RequestBody Map<String, Long> json) {
        return this.service.desbloqueiaFuncionario(id_funcionario, json);
    }
}
