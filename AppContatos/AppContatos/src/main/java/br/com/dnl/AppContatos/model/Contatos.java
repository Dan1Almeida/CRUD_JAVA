package br.com.dnl.AppContatos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.dnl.AppContatos.Enum.OrderTipo;
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
	
	// ----- ATRIBUTOS -----
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer orderTipo;
		
	@Column(nullable = false)
	private String contato;
	
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	@JsonBackReference
	private Pessoas pessoa;


	// ----- ENTIDADE -----
	
	public Contatos() {}
	
	public Contatos(Long id, OrderTipo orderTipo, String contato, Pessoas pessoa) {
		this.id = id;
		setOrderTipo(orderTipo);
		this.contato = contato;
		this.pessoa = pessoa;
	}
	
	
	// ----- GET e SET -----

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderTipo getOrderTipo() {
		return OrderTipo.valueOf(orderTipo);
	}

	public void setOrderTipo(OrderTipo orderTipo) {
		this.orderTipo = orderTipo.getTipo();
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
