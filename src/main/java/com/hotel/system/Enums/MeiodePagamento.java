package com.hotelaria.system.Sistema.Enums;

public enum MeiodePagamento {
    DINHEIRO(""),
    CARTÃO(""),
    PIX("");

    private final String meiodepagamento;

    MeiodePagamento(String meiodepagamento) {
        this.meiodepagamento = meiodepagamento;
    }

    public String meiodepagamento() {
        return meiodepagamento;
    }
}
