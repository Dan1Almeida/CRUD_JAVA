package br.com.dnl.AppContatos.Enum;

public enum OrderTipo {
	
	telefone_residencial(1),
	celular(2),
	whatsapp(3),
	email_pessoal(4),
	email_profissional(5);
	
	private int tipo;
	
	private OrderTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}
	
	public static OrderTipo valueOf(int tipo) {
		for (OrderTipo value : OrderTipo.values()) {
			if (tipo == value.getTipo() + 1) {
				return value; 
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
