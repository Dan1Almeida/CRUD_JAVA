package br.com.dnl.AppContatos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.dnl.AppContatos.Enum.OrderTipo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Schema(description = "Entidade que representa o contato de uma pessoa")
@Table (name = "tb_contatos")
public class Contatos {
	
	// ----- ATRIBUTOS -----
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador da contato dentro do sistema")
	private Long id;
	
	@Column(nullable = false)
	@Schema(description = "1-Residencial | 2-Celular | 3-Tel-Profissional | 4-E-mail "
						+ "| 5-E-mail Profissional | 6-Linkedin | 6-Xbox Live | 6-PSN ", example = "1")
	private Integer orderTipo;
		
	@Column(nullable = false, unique = true)
    @Schema(description = "Residencial", example = "(11) 1010-1010")
	private String contato;
	
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	@JsonIgnoreProperties("contatos")
	@JsonBackReference 
	@Schema(description = "Pessoa que está associado ao contato")
	private Pessoas pessoa;


	// ----- CONSTRUTOR -----
	
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
	
	// -------------------------------	

	public OrderTipo getOrderTipo() {
		return OrderTipo.valueOf(orderTipo);
	}

	public void setOrderTipo(OrderTipo orderTipo) {
		if (orderTipo != null) {
			this.orderTipo = orderTipo.getTipo();
		}
	}
	
	// -------------------------------	

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	// -------------------------------	

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
		
}
