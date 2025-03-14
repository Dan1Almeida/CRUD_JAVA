package br.com.dnl.AppContatos.Dto;

import br.com.dnl.AppContatos.model.Pessoas;

public record MalaDiretaDto(Long id, String nome, String malaDireta ) {
	
    public MalaDiretaDto(Pessoas pessoa) {
    	this(	pessoa.getId(),
                pessoa.getNome(),
                pessoa.getOrderLogradouro() + " " + pessoa.getEndereco() + ", Nº: " + pessoa.getNumero() + " – CEP: " + pessoa.getCep() + " – " + pessoa.getCidade() + " / " + pessoa.getOrderUf()
            );
    }

}
