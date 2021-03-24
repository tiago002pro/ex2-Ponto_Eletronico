package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;
}
