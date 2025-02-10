package br.com.dnl.AppContatos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;




@Entity
@Table (name = "tb_contatos")
public class Contatos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String contato;
	
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	@JsonBackReference
	private Pessoas pessoa;


	// ------ ENTIDADE
	
	public Contatos() {}
	
	public Contatos(Long id, String tipo, String contato, Pessoas pessoa) {
		this.id = id;
		this.tipo = tipo;
		this.contato = contato;
		this.pessoa = pessoa;
	}
	
	
	// ------- GET e SET

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
	
		
	
	/* @Override
	public String toString() {
		
	}
	*/
	
}
