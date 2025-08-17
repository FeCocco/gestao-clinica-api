package com.fegcocco.sistemaagendamento.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role; // CLIENTE ou PROFISSIONAL

    @Column(unique = true)
    private String email;
}
