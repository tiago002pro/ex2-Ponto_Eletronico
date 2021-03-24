package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Ponto;
import com.example.demo.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class PontoService {

    @Autowired
    PontoRepository repository;
    @Autowired
    FuncionarioService funcionarioService;

    public String registraPonto(Long id_funcionario) {
        Funcionario funcionario = this.funcionarioService.pegaFuncionario(id_funcionario);
        Ponto ponto = new Ponto();
        if (funcionario.getBloqueado()) {
            return "Acesso Bloqueado! Consulte o RH para o desbloqueio.";
        } else {
            zeraContadorDeAtrasos(funcionario);
            ponto.setFuncionario(funcionario);
            ponto.setData(LocalDate.now());
            ponto.setHorario(LocalTime.now());
            verificaAtraso(funcionario);
            bloqueiaFuncinario(funcionario);
            this.repository.save(ponto);
        }
        return "Ponto Registrado! Tenha um bom trabalho.";
    }

    public List<Ponto> getPontos() {
        return this.repository.findAll();
    }

    public void verificaAtraso(Funcionario funcionario) {
        LocalTime horarioEntrada = LocalTime.of(8,0,0);
        LocalTime horarioChegada = LocalTime.now();
        if (horarioChegada.isAfter(horarioEntrada)) {
            funcionario.setAtrasos(funcionario.getAtrasos() + 1);
        }
    }

    public void zeraContadorDeAtrasos(Funcionario funcionario) {
        LocalDate diaAtual = LocalDate.now();
        if (diaAtual.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            funcionario.setAtrasos(0);
        }
    }

    public void bloqueiaFuncinario(Funcionario funcionario) {
        if (funcionario.getAtrasos() >= 2) {
            funcionario.setBloqueado(true);
        }
    }

    public String desbloqueiaFuncionario(Long id_funcionario, Map<String, Long> json) {
        Funcionario funcionarioRH = funcionarioService.pegaFuncionario(json.get("idRH"));
        Funcionario funcionario = funcionarioService.pegaFuncionario(id_funcionario);

        if (funcionarioRH.getSetor_rh()) {
            if (funcionario.getBloqueado()) {
                funcionario.setBloqueado(false);
                this.funcionarioService.repository.save(funcionario);
                return "Funcionário desbloqueado com sucesso!";
            } else {
                return "Funcionário já está ativo!";
            }
        } else {
            return "Você não tem permissão pra executar essa tarefa!";
        }
    }
}
