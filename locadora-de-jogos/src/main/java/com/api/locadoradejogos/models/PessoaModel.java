package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPessoa;

    @Column(name = "TE_NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "TE_CPF", nullable = false, length = 14)
    private String cpf;

    @Column(name = "TE_RG", nullable = false, length = 20)
    private String rg;

    @Column(name = "TE_EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "TE_ENDERECO", nullable = false, length = 150)
    private String endereco;

    public UUID getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(UUID idPessoa) {
        this.idPessoa = idPessoa;
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

}