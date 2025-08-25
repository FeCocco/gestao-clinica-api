package com.fegcocco.sistemaagendamento.service;

import com.fegcocco.sistemaagendamento.entity.Agendamento;
import com.fegcocco.sistemaagendamento.entity.Role;
import com.fegcocco.sistemaagendamento.repository.AgendamentoRepository;
import com.fegcocco.sistemaagendamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UserRepository userRepository;

    public Agendamento criarAgendamento(Agendamento agendamento) {
        Long profissionalId = agendamento.getProfissional().getId();

        //o usuário existe E TEM A ROLE CORRETA?
        userRepository.findByIdAndRole(profissionalId, Role.PROFISSIONAL)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado ou usuário não tem permissão para receber agendamentos."));

        if (agendamento.getDataHoraInicio().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não é possível agendar em datas passadas.");
        }

        List<Agendamento> conflitos = agendamentoRepository.findConflictingAppointments(
                profissionalId,
                agendamento.getDataHoraInicio(),
                agendamento.getDataHoraFim()
        );

        if (!conflitos.isEmpty()) {
            throw new RuntimeException("Horário indisponível. Já existe um agendamento para este período.");
        }

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarAgendamentosDoMes(Long profissionalId, int ano, int mes) {
        LocalDateTime inicioMes = LocalDateTime.of(ano, mes, 1, 0, 0);
        LocalDateTime fimMes = inicioMes.plusMonths(1).minusNanos(1);

        return agendamentoRepository.findByProfissionalIdAndDataHoraInicioBetween(profissionalId, inicioMes, fimMes);
    }

    public void cancelarAgendamento(Long agendamentoId) {
        if (!agendamentoRepository.existsById(agendamentoId)) {
            throw new RuntimeException("Agendamento não encontrado!");
        }
        agendamentoRepository.deleteById(agendamentoId);
    }
}