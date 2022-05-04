package com.portoseguro.blogpessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome deve ser preenchido")
	@Size(min = 3, max = 255, message = "O campo nome deve conter entre 3 e 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O campo Email deve ser preenchido")
	@Size(min = 10, max = 255, message = "O campo email deve conter entre 10 e 255 caracteres")
	@Email(message = "O campo deve conter o caracter '@'")
	private String usuario;
	
	@NotBlank(message = "O campo senha deve ser preenchido")
	@Size(min = 8, max = 255, message = "O campo senha deve conter entre 8 e 255 caracteres")
	private String senha;
	
	private String foto;

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}