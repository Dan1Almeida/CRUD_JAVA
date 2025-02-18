package br.com.dnl.AppContatos.Enum;

public enum OrderTipo {
	
	Residencial(0),
    Celular(1),
    Telefone_Profissional(2),
    Email_pessoal(3),
    Email_profissional(4),
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