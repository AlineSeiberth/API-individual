package com.example.demo.domain;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message ="Preencha o Título")
	@Size(max = 255, min = 1)
	@Column(nullable = false, length = 255)
	private String titulo;
	
	private Integer qtdPaginas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	@JoinColumn(name = "publicacao_id")
	private Publicacao publicacao;

	public Livro() {
		
	}
	
	public Livro(Long id, String titulo, Integer qtdPaginas, Publicacao publicacao) {
		this.id = id;
		this.titulo = titulo;
		this.qtdPaginas = qtdPaginas;
		this.publicacao = publicacao;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, qtdPaginas, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id) && Objects.equals(qtdPaginas, other.qtdPaginas)
				&& Objects.equals(titulo, other.titulo);
	}

	
}
	
		
	
