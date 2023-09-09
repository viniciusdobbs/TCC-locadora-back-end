package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_LOCACAO")
public class LocacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOCACAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLocacao;

    @Column(name = "NU_VALOR_DIA")
    private double valorDia;

    @Column(name = "DT_LOCACAO")
    private Date dataLocacao;

    @Column(name = "DT_DEVOLUCAO")
    private Date dataDevolucao;

    @Column(name = "NU_VALOR_FINAL")
    private double valorFinal;

    @ManyToOne
    @JoinColumn(name="ID_JOGO", referencedColumnName="ID_JOGO")
    private JogosModel jogo;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", referencedColumnName="ID_PESSOA")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name="ID_FUNC", referencedColumnName="ID_PESSOA")
    private FuncionarioModel funcionario;

    public UUID getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(UUID idLocacao) {
        this.idLocacao = idLocacao;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
