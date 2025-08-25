package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", nullable = false)
    private User profissional;

    @ManyToOne
    private Servico servico;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime dataHoraFim;

    @Column(nullable = false)
    private String nomeCliente;
}

