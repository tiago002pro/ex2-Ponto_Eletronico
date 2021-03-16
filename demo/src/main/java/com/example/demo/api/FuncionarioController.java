package com.example.demo.api;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @PostMapping("/funcionarios")
    public String cadastraFuncionario(@RequestBody Map<String, Object> json) {
        return this.service.cadastraFuncionario(json);
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> getFuncionarios() {
        return this.service.getFuncionarios();
    }

}
