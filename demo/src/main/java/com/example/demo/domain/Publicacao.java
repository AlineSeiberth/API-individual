package com.example.demo.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Publicacao {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message ="Preencha o autor")
	@Size(max = 255, min = 1)
	@Column(nullable = false, length = 255)
	private String autor;
	
	
	private LocalDate dataPublicacao;
	
	private String editora;
	
	public Publicacao() {
	}

	public Publicacao(Long id,  String autor, LocalDate dataPublicacao, String editora) {
		this.id = id;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.editora = editora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, dataPublicacao, editora, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(dataPublicacao, other.dataPublicacao)
				&& Objects.equals(editora, other.editora) && Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
