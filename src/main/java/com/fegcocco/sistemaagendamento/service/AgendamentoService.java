package com.fegcocco.sistemaagendamento.service;

import com.fegcocco.sistemaagendamento.dto.AgendamentoResponseDTO;
import com.fegcocco.sistemaagendamento.entity.Agendamento;
import com.fegcocco.sistemaagendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<AgendamentoResponseDTO> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {

        List<Agendamento> agendamentos = agendamentoRepository.findByInicioBetween(inicio, fim);

        return agendamentos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private AgendamentoResponseDTO converterParaDTO(Agendamento agendamento) {

        AgendamentoResponseDTO dto = new AgendamentoResponseDTO();

        dto.setId(agendamento.getId());

        dto.setInicio(agendamento.getInicio());
        dto.setFim(agendamento.getFim());

        String Titulo = agendamento.getServico().getNome() + " - " + agendamento.getCliente().getNome();
        dto.setNome(Titulo);

        return dto;
    }
}
