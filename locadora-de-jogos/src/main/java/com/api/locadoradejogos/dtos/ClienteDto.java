package com.api.locadoradejogos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDto {

    @NotBlank
    private String nome;

    @NotNull
    private Double idadeCliente;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefoneCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(Double idadeCliente) {
        this.idadeCliente = idadeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
