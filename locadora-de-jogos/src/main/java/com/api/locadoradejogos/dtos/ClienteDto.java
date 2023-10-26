package com.api.locadoradejogos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
