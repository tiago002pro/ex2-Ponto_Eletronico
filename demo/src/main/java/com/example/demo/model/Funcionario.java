package com.example.demo.model;

import liquibase.datatype.core.IntType;
import liquibase.datatype.core.SmallIntType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "setor_rh")
    private Boolean setor_rh;

    @Column(name = "atrasos")
    private Integer atrasos;

    @Column(name = "bloqueado")
    private Boolean bloqueado;
}
