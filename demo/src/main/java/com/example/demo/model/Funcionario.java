package com.example.demo.model;

public class Funcionario {
    private String nome;
    private Boolean rh;
    private Integer contaAtraso;
    private Boolean bloqueio;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setRh(Boolean rh) {
        this.rh = rh;
    }

    public Boolean getRh() {
        return rh;
    }

    public void setContaAtraso(Integer contaAtraso) {
        this.contaAtraso = contaAtraso;
    }

    public Integer getContaAtraso() {
        return contaAtraso;
    }

    public void setBloqueio(Boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    public Boolean getBloqueio() {
        return bloqueio;
    }
}
