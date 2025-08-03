package com.fegcocco.sistemaagendamento.controller;

import com.fegcocco.sistemaagendamento.entity.User;
import com.fegcocco.sistemaagendamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/usuarios")
    public List<User> listaUsuarios(){
        return userRepository.findAll();
    }

    @GetMapping("/usuarios/{cpf}")
    public List<User> listarUsuarioEspecifico(@PathVariable(value="cpf")String cpf){
        return userRepository.findByCpf(cpf);
    }

    @PostMapping("/usuarios")
    public  User salvarUsuario(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/usuarios")
    public void deletarUsuario(@RequestBody User user){
        userRepository.delete(user);
    }

    @PutMapping("/usuarios")
    public User atualizarUsuario(@RequestBody User user){
        return userRepository.save(user);
    }
}
