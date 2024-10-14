package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Livro;


@Repository
public interface  LivroRepository  extends  JpaRepository<Livro, Long>{

}
