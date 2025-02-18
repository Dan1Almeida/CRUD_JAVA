package br.com.dnl.AppContatos.Enum;

public enum OrderTipo {
	
	Residencial(0),
    celular(1),
    Tel_Profissional(2),
    email_pessoal(3),
    email_profissional(4),
    linkedin(5),
    XboxLive(6),
    PSN(7);
	
    private int tipo;
	
    private OrderTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
	
    public static OrderTipo valueOf(int tipo) {
        for (OrderTipo value : OrderTipo.values()) {
            if (tipo == value.getTipo()) { 
                return value; 
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
