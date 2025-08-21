package com.fegcocco.sistemaagendamento.repository;

import com.fegcocco.sistemaagendamento.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByDataHora(LocalDateTime inicio, LocalDateTime fim);

}
