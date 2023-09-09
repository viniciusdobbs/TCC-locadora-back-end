package com.api.locadoradejogos.dtos;

import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.FuncionarioModel;
import com.api.locadoradejogos.models.JogosModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class LocacaoDto {

    @NotNull
    private double valor;

    @NotNull
    private int dia;

    @NotNull
    private JogosModel jogo;

    @NotNull
    private ClienteModel cliente;

    @NotNull
    private FuncionarioModel funcionario;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dataDevolucao;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public JogosModel getJogo() {
        return jogo;
    }

    public void setJogo(JogosModel jogo) {
        this.jogo = jogo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
