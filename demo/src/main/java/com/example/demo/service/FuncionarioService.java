package com.example.demo.service;

import com.example.demo.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FuncionarioService {

    List<Funcionario> funcionarios = new ArrayList<>();

    public String cadastraFuncionario(Map<String, Object> json) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome((String) json.get("Nome"));
        funcionario.setRh((Boolean) json.get("SetorRH"));
        funcionario.setContaAtraso(0);
        funcionario.setBloqueio(false);
        funcionarios.add(funcionario);

        return "Funcionário cadastrado com sucesso!";
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
