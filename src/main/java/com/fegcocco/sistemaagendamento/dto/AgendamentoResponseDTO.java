package com.fegcocco.sistemaagendamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoResponseDTO {

    private Long id;
    private String nome;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String cor;
}
