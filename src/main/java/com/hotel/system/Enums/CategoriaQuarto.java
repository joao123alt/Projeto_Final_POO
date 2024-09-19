package com.hotelaria.system.Sistema.Enums;

public enum CategoriaQuarto {
    BASICO("QUARTO MAIS BARATO"),
    INTERMEDIARIO("COMPLETO, MAS SEM LUXO"),
    STANDARD("SUITE LUXO");

    private final String descricaoQuarto;

    CategoriaQuarto(String descricaoQuarto) {
        this.descricaoQuarto = descricaoQuarto;
    }

    public String descricaoQuarto() {
        return descricaoQuarto;
    }
}
