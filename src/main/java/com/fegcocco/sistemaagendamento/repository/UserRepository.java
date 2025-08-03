package com.fegcocco.sistemaagendamento.repository;

import com.fegcocco.sistemaagendamento.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByCpf(String cpf);

}
