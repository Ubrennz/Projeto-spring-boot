package com.neiloalves.projetospringboot2.enums;

public enum StatusPedido {
    // atribuindo um valor int para cada enum
    ESPERANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int code;

    StatusPedido(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusPedido valueOf(int code) {
        for (StatusPedido statusPedidoValor : StatusPedido.values()) { // valores do StatusPedido (enums)
            if (statusPedidoValor.getCode() == code) {
                return statusPedidoValor;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
