package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Publicacao;

public interface PublicacaoRepository extends  JpaRepository<Publicacao, Long> {

}
