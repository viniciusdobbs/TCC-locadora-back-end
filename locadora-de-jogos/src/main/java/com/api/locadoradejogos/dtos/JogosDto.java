package com.api.locadoradejogos.dtos;

import com.api.locadoradejogos.enums.ConsoleEnum;
import com.api.locadoradejogos.enums.GeneroEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class JogosDto {

    @NotBlank
    private String nome;

    private GeneroEnum genero;

    private ConsoleEnum console;

    @NotNull
    private double preco;

    @NotNull
    private double quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public ConsoleEnum getConsole() {
        return console;
    }

    public void setConsole(ConsoleEnum console) {
        this.console = console;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
