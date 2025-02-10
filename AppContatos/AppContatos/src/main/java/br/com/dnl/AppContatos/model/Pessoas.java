package br.com.dnl.AppContatos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-Incremento
	private Long id;
	
	@Column(nullable = false, length = 2) //Not Null
	private String nome;
	
	@Column(nullable = false) //Not Null
	private String endereco;
	
	@Column(nullable = false) //Not Null
	private String cep;
	
	@Column(nullable = false) //Not Null
	private String cidade;
	
	@Column(nullable = false) //Not Null
	private String uf;
	
	@OneToMany(mappedBy = "pessoa")
	@JsonManagedReference
	private List<Contatos> contato;
	
	// ------- ENTIDADE
	
	public Pessoas() { }
	
	public Pessoas(Long id, String nome, String endereco, String cep, String cidade, String uf ) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		
	}
	
	//----- Get e Setters ----- 

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
	
	
	// ----- toString -----
	


	@Override
	public String toString() {
		String retorno = "[" +
						"Nome:" + 		this.nome + 		"," +
						"Endereço:" + 	this.endereco + 	"," +
						"CEP:" + 		this.cep + 			"," +
						"Cidade:" + 	this.cidade + 		"," +
						"UF:" + 		this.uf + 			"]" ;
		return retorno;
	}

	
}
