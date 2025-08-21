package com.fegcocco.sistemaagendamento.controller;

import com.fegcocco.sistemaagendamento.dto.AgendamentoResponseDTO;
import com.fegcocco.sistemaagendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin (origins = "*")

public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> buscarAgendamentos(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {

            List<AgendamentoResponseDTO> agendamentos = agendamentoService.buscarPorPeriodo(inicio, fim);

            return ResponseEntity.ok(agendamentos);

        }

    //@PostMapping (...)
}


