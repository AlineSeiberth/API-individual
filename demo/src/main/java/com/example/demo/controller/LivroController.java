package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Livro;
import com.example.demo.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/livro")
public class LivroController {


@Autowired	
private LivroRepository repositorio;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Livro postMethodName(@Valid @RequestBody Livro livro) {
    livro = repositorio.save(livro);
    return livro;
}

@GetMapping
public ResponseEntity<List<Livro>> listar() {
	return ResponseEntity.ok(repositorio.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<Livro> buscar(@PathVariable Long id) {
	Optional<Livro> livroOpt = repositorio.findById(id);
	if (livroOpt.isPresent()) {
		return ResponseEntity.ok(livroOpt.get());
	}
	return ResponseEntity.notFound().build();
}

@PutMapping("/{id}")
public ResponseEntity<Livro> alterar(@PathVariable Long id,
		@Valid @RequestBody Livro livro) {
	if (!repositorio.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	livro.setId(id);
	livro = repositorio.save(livro);
	return ResponseEntity.ok(livro);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> remover(@PathVariable Long id) {
	
	repositorio.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
