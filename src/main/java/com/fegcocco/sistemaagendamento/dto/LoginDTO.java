package com.fegcocco.sistemaagendamento.dto;

public class LoginDTO {
    private String email;
    private String cpf;
    private String senha;

    // Getters e setters
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setEmail(String email) { this.email = email; }
}


