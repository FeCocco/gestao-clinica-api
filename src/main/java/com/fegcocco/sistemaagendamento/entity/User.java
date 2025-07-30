package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class User {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role; // CLIENTE ou PROFISSIONAL
}
