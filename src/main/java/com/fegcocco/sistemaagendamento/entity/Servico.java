package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@Entity
public class Servico {
    @Id @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Duration duracao; // Ex: 30min
}

