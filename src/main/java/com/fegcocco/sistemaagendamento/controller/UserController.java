package com.fegcocco.sistemaagendamento.controller;

import com.fegcocco.sistemaagendamento.dto.LoginDTO;
import com.fegcocco.sistemaagendamento.entity.Role;
import com.fegcocco.sistemaagendamento.entity.User;
import com.fegcocco.sistemaagendamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/usuarios/email/{email}")
    public ResponseEntity<Boolean> verificaEmail(@PathVariable(value = "email") String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user.isPresent());
    }

    @GetMapping("/profissionais")
    public ResponseEntity<List<User>> getProfissionais() {
        List<User> profissionais = userRepository.findByRole(Role.PROFISSIONAL);
        return ResponseEntity.ok(profissionais);
    }

    @PostMapping("/usuarios")
    public User salvarUsuario(@RequestBody User user) {
        String senhaCriptografada = passwordEncoder.encode(user.getSenha());
        user.setSenha(senhaCriptografada);
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).body("E-mail ou senha inválidos.");
        }

        User user = userOptional.get();

        if (passwordEncoder.matches(loginDTO.getSenha(), user.getSenha())) {
            user.setSenha(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("E-mail ou senha inválidos.");
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody Map<String, Object> dadosAtualizacao) {
        return userRepository.findById(id)
                .map(usuarioExistente -> {
                    if (dadosAtualizacao.containsKey("cpf")) {
                        String cpf = (String) dadosAtualizacao.get("cpf");
                        usuarioExistente.setCpf(cpf);
                    }
                    User usuarioAtualizado = userRepository.save(usuarioExistente);
                    return ResponseEntity.ok(usuarioAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}