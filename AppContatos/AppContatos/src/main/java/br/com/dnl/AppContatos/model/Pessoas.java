package br.com.dnl.AppContatos.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	
	@Column(nullable = false) 
	@Schema(description = "Nome completo", example = "Daniel Silva de Almeida")
	private String nome;
	
	@Column(nullable = false) 
	@Schema(description = "Endereço da pessoa", example = "Rua Um")
	private String endereco;
	
	@Column(nullable = false) 
	@Schema(description = "CEP do endereço", example = "01010-101")
	private String cep;
	
	@Column(nullable = false) 
	@Schema(description = "Cidade", example = "São Paulo")
	private String cidade;
	
	@Column(nullable = false)
	@Schema(description = "Unidade federativa (UF)", example = "SP")
	private String uf;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Schema(hidden = true)
	private List<Contatos> contato;
	
	// ----- ENTIDADES -----
	
	public Pessoas() { }
	
	public Pessoas(Long id, String nome, String endereco, String cep, String cidade, String uf, List<Contatos> contato ) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
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
	

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	public List<Contatos> getContato() {
		return contato;
	}

	public void setContato(List<Contatos> contato) {
		this.contato = contato;
	}	
		
}
