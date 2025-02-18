package br.com.dnl.AppContatos.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.dnl.AppContatos.Enum.OrderLogradouro;
import br.com.dnl.AppContatos.Enum.OrderUf;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity

@Table(name = "tb_pessoas")
public class Pessoas {
	
	// ----- ATRIBUTOS -----
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	
	@Column(nullable = false)  // Não Nulo 
	@Schema(description = "Nome completo", example = "Daniel Silva de Almeida")
	private String nome;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Schema(description = "Tipo de Logradouro", example = "RUA")
	private OrderLogradouro orderLogradouro;
	
	@Column(nullable = false) 
	@Schema(description = "Endereço da pessoa", example = "Rua Um")
	private String endereco;
	
	@Column(nullable = false) 
	@Schema(description = "Número da casa", example = "1")
	private Integer numero;
	
	@Column(nullable = false) 
	@Schema(description = "CEP do endereço", example = "01010-101")
	private String cep;
	
	@Column(nullable = false) 
	@Schema(description = "Cidade", example = "Osasco")
	private String cidade;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Schema(description = "Unidade federativa (UF)", example = "SP")
    private OrderUf orderUf;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JsonManagedReference // Interromper Serialização
	@Schema(hidden = true)
	private List<Contatos> contato;
	
	// ----- CONSTRUTOR  -----
	
	public Pessoas() { }
	
	public Pessoas(Long id, String nome, OrderLogradouro orderLogradouro, String endereco,int numero, String cep, String cidade, OrderUf orderUf, List<Contatos> contato ) {
		this.id = id;
		this.nome = nome;
		this.orderLogradouro = orderLogradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.orderUf = orderUf;
		this.contato = contato;
	}
	
	// ----- Get e Setters ----- 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

	public String getOrderUf() {
	    return (orderUf != null) ? orderUf.getUf() : null;
	}

	public void setOrderUf(String uf) {
	    if (uf != null) {
	        try {
	            this.orderUf = OrderUf.valueOf(uf.toUpperCase()); 
	        } catch (IllegalArgumentException e) {
	            this.orderUf = null; 
	        }
	    } else {
	        this.orderUf = null;
	    }
	}
	
	public String getOrderLogradouro() {
		return (orderLogradouro != null) ? orderLogradouro.getTipoLog() : null;
	}
	
	public void setOrderLogradouro(String TipoLog) {
		if (TipoLog != null) {
			try {
				this.orderLogradouro = OrderLogradouro.valueOf(TipoLog.toUpperCase());
			} catch (IllegalArgumentException e) {
				this.orderLogradouro = null;
			}
		} else {
			this.orderLogradouro = null;
		}
	}
	
	public List<Contatos> getContato() {
		return contato;
	}

	public void setContato(List<Contatos> contato) {
		this.contato = contato;
	}

}
