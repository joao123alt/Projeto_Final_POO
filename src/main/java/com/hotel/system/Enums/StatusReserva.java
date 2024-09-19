package com.hotelaria.system.Sistema.Enums;

public enum StatusReserva {

    CONCLUIDO("PAGO"),
    PENDENTE("NÃO PAGO");

    private final String statusPagamento;

    StatusReserva(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getstatusPagamento() {
        return statusPagamento;
    }
       
}