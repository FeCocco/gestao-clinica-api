package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User cliente;

    @ManyToOne
    private User profissional;

    @ManyToOne
    private Servico servico;

    private LocalDateTime dataHora;
}

