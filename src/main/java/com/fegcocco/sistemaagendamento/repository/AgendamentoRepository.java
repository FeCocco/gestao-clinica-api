package com.fegcocco.sistemaagendamento.repository;

import com.fegcocco.sistemaagendamento.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("SELECT a FROM Agendamento a WHERE a.profissional.id = :profissionalId AND a.dataHoraInicio < :fim AND a.dataHoraFim > :inicio")
    List<Agendamento> findConflictingAppointments(Long profissionalId, LocalDateTime inicio, LocalDateTime fim);

    List<Agendamento> findByProfissionalIdAndDataHoraInicioBetween(Long profissionalId, LocalDateTime inicioMes, LocalDateTime fimMes);
}