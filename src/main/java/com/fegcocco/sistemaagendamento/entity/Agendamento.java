package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Agendamento {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private User cliente;

    @ManyToOne
    private User profissional;

    @ManyToOne
    private Servico servico;

    private LocalDateTime inicio;
    private LocalDateTime fim;

}

