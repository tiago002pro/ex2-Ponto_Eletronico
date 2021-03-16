package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ponto {
    private Funcionario funcionario;
    private LocalDate data;
    private LocalTime horario;

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getHorario() {
        return horario;
    }
}
