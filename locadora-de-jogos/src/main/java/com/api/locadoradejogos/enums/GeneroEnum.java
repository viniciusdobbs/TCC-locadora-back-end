package com.api.locadoradejogos.enums;

public enum GeneroEnum {

    ACAO (1,"Ação"),
    AVENTURA (2,"Aventura"),
    RPG (3,"Role Playing (RPG)"),
    SIMULACAO (4,"Simulação"),
    PUZZLE (5,"Quebra cabeça"),
    ESPORTE (6,"Esportes"),
    ESTRATEGIA (7,"Estratégia");

    private int codigo;
    private String label;

    private GeneroEnum(int codigo, String label){
        this.label = label;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLabel() {
        return label;
    }
}
