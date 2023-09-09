package com.api.locadoradejogos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuncionarioDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String email;

    @NotBlank
    private String endereco;

    @NotNull
    private double salarioFunc;

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

    public double getSalarioFunc() {
        return salarioFunc;
    }

    public void setSalarioFunc(double salarioFunc) {
        this.salarioFunc = salarioFunc;
    }
}
