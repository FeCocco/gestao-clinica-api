package com.fegcocco.sistemaagendamento.dto;

import com.fegcocco.sistemaagendamento.entity.Agendamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoResponseDTO {
    private Long id;
    private String nomeCliente;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Long profissionalId;
    private String profissionalNome;

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.nomeCliente = agendamento.getNomeCliente();
        this.dataHoraInicio = agendamento.getDataHoraInicio();
        this.dataHoraFim = agendamento.getDataHoraFim();
        this.profissionalId = agendamento.getProfissional().getId();
        this.profissionalNome = agendamento.getProfissional().getNome();
    }

}