package com.api.locadoradejogos.models;

import com.api.locadoradejogos.enums.ConsoleEnum;
import com.api.locadoradejogos.enums.GeneroEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_JOGOS")
public class JogosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_JOGO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idJogo;

    @Column(name = "TE_NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EN_GENERO", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "EN_CONSOLE", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private ConsoleEnum console;

    @Column(name = "NU_PRECO", nullable = false, length = 10)
    private double preco;

    @OneToMany(mappedBy="jogo")
    private List<LocacaoModel> locacao;

    public UUID getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(UUID idJogo) {
        this.idJogo = idJogo;
    }

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
}
