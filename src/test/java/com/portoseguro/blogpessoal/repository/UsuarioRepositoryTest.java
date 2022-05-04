package com.portoseguro.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.portoseguro.blogpessoal.model.Usuario;

/*
 * - RANDOM_PORT: SE A PORTA PRINICPAL ESTIVER OCUPADA O SPRING VAI ATRIBUIR UMA NOVA PORTA 
 * AUTOMATICAMENTE
 * - TestInstance.Lifecycle.PER_CLASS: INDICA QUE O CICLO DE VIDA DA CLASSE CRIADA SERÁ POR CLASSE
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L, "Docinho", "docinho@email.com", "docinho123", "foto"));
		usuarioRepository.save(new Usuario(0L, "Lindinha", "lindinha@email.com", "lindinha123", "foto2"));
		usuarioRepository.save(new Usuario(0L, "Florzinha", "florzinha@email.com", "florzinha123", "foto3"));
		usuarioRepository.save(new Usuario(0L, "Macaco louco", "mclouco@email.com", "mclouco123", "foto4"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("docinho@email.com");
		assertTrue(usuario.get().getUsuario().equals("docinho@email.com"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuários")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Macaco louco");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Florzinha"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Lindinha"));
		assertTrue(listaDeUsuarios.get(3).getNome().equals("Docinho"));
	}
}
