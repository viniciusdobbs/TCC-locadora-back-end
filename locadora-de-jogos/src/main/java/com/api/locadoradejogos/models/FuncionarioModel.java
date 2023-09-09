package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioModel extends PessoaModel{

    @Column(name = "NU_SALARIO", nullable = false)
    private double salarioFunc;

    @OneToMany(mappedBy="funcionario")
    private List<LocacaoModel> locacao;

    public FuncionarioModel() {
        super();
    }

    public double getSalarioFunc() {
        return salarioFunc;
    }

    public void setSalarioFunc(double salarioFunc) {
        this.salarioFunc = salarioFunc;
    }
}
