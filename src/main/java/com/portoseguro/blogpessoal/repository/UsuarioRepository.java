package com.portoseguro.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portoseguro.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	/*
	 * A INTERFACE É RESPONSÁVEL PELA COMUNICAÇÃO DA API COM A BASE DE DADOS
	 * OPTIONAL PODE RETORNAR UM VALOR NULO
	 */
	
	public Optional<Usuario> findByUsuario(String Usuario);
	
	/*
	 * MÉTODO IMPLEMENTADO PARA REALIZAÇÃO DE TESTES COM JUNIT
	 */
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}

