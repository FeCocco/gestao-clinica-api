package com.fegcocco.sistemaagendamento.controller;

import com.fegcocco.sistemaagendamento.entity.User;
import com.fegcocco.sistemaagendamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/Usuarios")
    public List<User> listaUsuarios(){
        return userRepository.findAll();
    }

    @GetMapping("/Usuarios/{email}")
    public List<User> listaUsuarioEspecifico(@PathVariable(value="email")String email){
        return userRepository.findByEmail(email);
    }

}
