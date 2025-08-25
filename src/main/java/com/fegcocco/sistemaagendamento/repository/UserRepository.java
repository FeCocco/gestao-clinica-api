package com.fegcocco.sistemaagendamento.repository;

import com.fegcocco.sistemaagendamento.entity.Role;
import com.fegcocco.sistemaagendamento.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    //listar todos os profissionais disponiveis
    List<User> findByRole(Role role);

    //validar se um usuário existe E é um profissional
    Optional<User> findByIdAndRole(Long id, Role role);

}
