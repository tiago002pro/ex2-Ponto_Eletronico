package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public String cadastraFuncionario(Map<String, Object> json) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome((String) json.get("Nome"));
        funcionario.setSetor_rh((Boolean) json.get("SetorRH"));
        funcionario.setAtrasos(0);
        funcionario.setBloqueado(false);
        this.repository.save(funcionario);
        return "Funcionário cadastrado com sucesso!";
    }

    public List<Funcionario> pegaFuncionarios() {
        return this.repository.findAll();
    }
    public Funcionario pegaFuncionario(Long id_funcionario) {
        return this.repository.findById(id_funcionario).get();
    }
}
