package com.fegcocco.sistemaagendamento.controller;

import com.fegcocco.sistemaagendamento.dto.AgendamentoResponseDTO;
import com.fegcocco.sistemaagendamento.entity.Agendamento;
import com.fegcocco.sistemaagendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<AgendamentoResponseDTO>> getAgendamentosDoMes(
            @PathVariable Long profissionalId,
            @RequestParam int ano,
            @RequestParam int mes) {

        List<AgendamentoResponseDTO> agendamentos = agendamentoService.buscarAgendamentosDoMes(profissionalId, ano, mes);
        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
            return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{agendamentoId}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long agendamentoId) {
        try {
            agendamentoService.cancelarAgendamento(agendamentoId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}