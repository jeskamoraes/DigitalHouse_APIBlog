package com.portoseguro.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portoseguro.blogpessoal.model.Tema;
import com.portoseguro.blogpessoal.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(temaRepository.findAll());
	}

	@GetMapping("/{idTema}")
	public ResponseEntity<Tema> getById(@PathVariable Long idTema) {
		return temaRepository.findById(idTema).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nomeTema}")
	public ResponseEntity<List<Tema>> getByNome(@PathVariable String nomeTema) {
		return ResponseEntity.ok(temaRepository.findAllByNomeTemaContainingIgnoreCase(nomeTema));
	}

	@PostMapping
	public ResponseEntity<Tema> postTema(@Valid @RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> putTema(@Valid @RequestBody Tema tema) {
		return temaRepository.findById(tema.getIdTema()).map(resposta -> {
			return ResponseEntity.ok().body(temaRepository.save(tema));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idTema}")
	public ResponseEntity<?> deleteTema(@PathVariable Long idTema) {
		return temaRepository.findById(idTema).map(resposta -> {
			temaRepository.deleteById(idTema);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
