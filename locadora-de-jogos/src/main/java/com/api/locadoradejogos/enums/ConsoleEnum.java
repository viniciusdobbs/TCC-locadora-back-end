package com.api.locadoradejogos.enums;

public enum ConsoleEnum {

    PS4 (1,"Playstation 4"),
    XBOX (2,"XBOX ONE"),
    SWITCH (3,"Nintendo Switch"),
    PC (4,"Computador");

    private int codigo;
    private String label;

    private ConsoleEnum(int codigo, String label){
        this.label = label;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLabel() {
        return label;
    }
}
