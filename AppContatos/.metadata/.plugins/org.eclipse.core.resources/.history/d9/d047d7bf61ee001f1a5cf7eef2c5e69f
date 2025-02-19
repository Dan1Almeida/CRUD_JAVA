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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


	@Entity
	@Schema(description = "Entidade que representa uma pessoa e seus atributos")
	@Table(name = "tb_pessoas")
	public class Pessoas {
	
	// ----- ATRIBUTOS -----------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador da pessoa dentro do sistema")
	private Long id;

	// -------------------------------------------------------------------------

	@Column(nullable = false)
	@Size(max = 150)
	@Pattern(regexp = "^[^\\d]*$")
	@Schema(description = "Nome completo", example = "Daniel Almeida")
	private String nome;

	// -------------------------------------------------------------------------

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	@Schema(description = "CPF", example = "010.101.010-10")
	private String cpf;

	// -------------------------------------------------------------------------

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Schema(description = "Tipo de Logradouro", example = "RUA")
	private OrderLogradouro orderLogradouro;

	// -------------------------------------------------------------------------

	@Column(nullable = false) 
	@Size(max = 100)
	@Pattern(regexp = "^[^0-9]*$")
	@Schema(description = "Endereço da pessoa", example = "Vincent Van Gogh")
	private String endereco;

	// -------------------------------------------------------------------------

	@Column(nullable = false) 
	@Min(value = 1)
	@Max(value = 9999)
	@Schema(description = "Número da casa", example = "1")
	private int numero;

	// -------------------------------------------------------------------------

	@Column(nullable = false) 
	@Pattern(regexp = "\\d{5}-\\d{3}")
	@Schema(description = "CEP do endereço", example = "01010-101")
	private String cep;

	// -------------------------------------------------------------------------

	@Column(nullable = false) 
	@Size(max = 35)
	@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$")
	@Schema(description = "Cidade", example = "Osasco")
	private String cidade;

	// -------------------------------------------------------------------------

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Schema(description = "Unidade federativa (UF)", example = "SP")
	private OrderUf orderUf;

	// -------------------------------------------------------------------------

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Schema(description = "Contatos associados a uma pessoa", hidden = true)
	private List<Contatos> contato;

	// ----- CONSTRUTOR  -----------------------------------------------------------

	public Pessoas() { }

	public Pessoas(Long id, String nome, String cpf, OrderLogradouro orderLogradouro, String endereco,int numero, 
				String cep, String cidade, OrderUf orderUf, List<Contatos> contato ) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.orderLogradouro = orderLogradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.orderUf = orderUf;
		this.contato = contato;
	}

	// ----- Get e Setters -----------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	// -------------------------------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// -------------------------------------------------------------------------

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	// -------------------------------------------------------------------------

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// -------------------------------------------------------------------------

	public int getNumero() {
		return numero;
	}

	public void setNumero(double numero) {

		if (numero % 1 != 0) {
			System.out.println("Número inserido de forma inválida.");
			throw new IllegalArgumentException();
		}
		this.numero = (int) numero; 
	}

	// -------------------------------------------------------------------------

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	// -------------------------------------------------------------------------

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// -------------------------------------------------------------------------	
	
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

	// -------------------------------------------------------------------------
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

	// -------------------------------------------------------------------------
	
	public List<Contatos> getContato() {
		return contato;
	}

	public void setContato(List<Contatos> contato) {
		this.contato = contato;
	}
}
