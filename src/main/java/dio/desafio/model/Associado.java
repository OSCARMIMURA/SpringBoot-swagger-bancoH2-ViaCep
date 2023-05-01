package dio.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Associado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Endereco enderecoResdencial;
	
	@ManyToOne
	private Endereco enderecoComercial;
	
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

	public Endereco getEnderecoResdencial() {
		return enderecoResdencial;
	}

	public void setEnderecoResdencial(Endereco enderecoResdencial) {
		this.enderecoResdencial = enderecoResdencial;
	}

	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}

	
	
	
	
	
}
