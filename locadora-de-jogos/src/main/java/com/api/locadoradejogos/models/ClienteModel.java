package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;

    @Column(name = "TE_NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "TE_CPF", nullable = false, length = 14)
    private String cpf;

    @Column(name = "TE_EMAIL", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy="cliente")
    private List<LocacaoModel> locacao;

    public ClienteModel() {
        super();
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
