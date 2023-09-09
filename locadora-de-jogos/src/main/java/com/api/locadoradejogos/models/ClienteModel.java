package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel {

    @Column(name = "TE_TELEFONE", nullable = false, length = 20)
    private String telefoneCliente;

    @Column(name = "NU_IDADE", nullable = false)
    private double idadeCliente;

    @OneToMany(mappedBy="cliente")
    private List<LocacaoModel> locacao;

    public ClienteModel() {
        super();
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public double getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(double idadeCliente) {
        this.idadeCliente = idadeCliente;
    }
}
