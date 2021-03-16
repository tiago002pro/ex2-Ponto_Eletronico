package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Ponto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PontoService {

    @Autowired
            FuncionarioService funcionarioService;

    List<Ponto> pontos = new ArrayList<>();

    public String registraPonto(Map<String, Object> json) {
        Funcionario funcionario = funcionarioService.funcionarios.get((Integer) json.get("idFuncionario"));
        Ponto ponto = new Ponto();

        if (funcionario.getBloqueio()) {

            return "Acesso Bloqueado! Consulte o RH para o desbloqueio.";
        } else {
            zeraContadorDeAtrasos(funcionario);

            ponto.setFuncionario(funcionario);
            ponto.setData(LocalDate.now());
            ponto.setHorario(LocalTime.now());

            verificaAtraso(funcionario);
            bloqueiaFuncinario(funcionario);
            pontos.add(ponto);
        }
        return "Ponto Registrado! Tenha um bom trabalho.";
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void verificaAtraso(Funcionario funcionario) {
        LocalTime horarioEntrada = LocalTime.of(8,0,0);
        LocalTime horarioChegada = LocalTime.now();

        if (horarioChegada.isAfter(horarioEntrada)) {
            funcionario.setContaAtraso(funcionario.getContaAtraso() + 1);
        }
    }

    public void zeraContadorDeAtrasos(Funcionario funcionario) {
        LocalDate diaAtual = LocalDate.now();

        if (diaAtual.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            funcionario.setContaAtraso(0);
        }
    }

    public void bloqueiaFuncinario(Funcionario funcionario) {

        if (funcionario.getContaAtraso() >= 2) {
            funcionario.setBloqueio(true);
        }
    }

    public String desbloqueiaFuncionario(Map<String, Object> json) {
        Funcionario funcionarioRH = funcionarioService.funcionarios.get((Integer) json.get("idRH"));
        Funcionario funcionario = funcionarioService.funcionarios.get((Integer) json.get("idFuncionario"));

        if (funcionarioRH.getRh()) {
            if (funcionario.getBloqueio()) {
                funcionario.setBloqueio(false);

                return "Funcionário desbloqueado com sucesso!";
            } else {

                return "Funcionário já está ativo!";
            }
        } else {

            return "Você não tem permissão pra executar essa tarefa!";
        }
    }
}
