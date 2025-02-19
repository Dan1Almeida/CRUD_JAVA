package br.com.dnl.AppContatos.Enum;

public enum OrderLogradouro {
	
	RUA("Rua"),
	AVENIDA("Avenida"),
	ESTRADA("Estrada"),
	TRAVESSA("Travessa"),
	VILA("Vila"),
	QUADRA("Quadra");

	private String TipoLog;

	OrderLogradouro(String TipoLog){
		this.TipoLog =TipoLog;
	}

	public String getTipoLog() {
		return TipoLog;
	}

	public void setTipoLog(String tipoLog) {
		TipoLog = tipoLog;
	}

	public static OrderLogradouro fromString(String TipoLog) {
		if (TipoLog != null) {
			for (OrderLogradouro Logradouro : OrderLogradouro.values()) {
				if (Logradouro.TipoLog.equalsIgnoreCase(TipoLog)) { 
					return Logradouro;
				}
			}
		}
		throw new IllegalArgumentException();
	}
	
}
