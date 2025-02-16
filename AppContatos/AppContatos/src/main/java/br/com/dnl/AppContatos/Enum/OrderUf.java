package br.com.dnl.AppContatos.Enum;


public enum OrderUf {
    
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"), MA("MA"), 
    MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), 
    RS("RS"), RO("RO"), RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");

    private String uf;

       
    OrderUf(String uf) {
        this.uf = uf;
    }

    public String getUf() {
        return uf;
    }
    
    public static OrderUf fromString(String uf) {
        if (uf != null) {
            for (OrderUf estado : OrderUf.values()) {
                if (estado.uf.equalsIgnoreCase(uf)) { 
                    return estado;
                }
            }
        }
        throw new IllegalArgumentException();
    }



   
}

   