package br.org.serratec.bibliotecaPaixao.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
	PRIMARY KEY (user_id)
 */

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "userId",
		scope = Usuario.class
		)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_nome")
	private String userNome;
	
	@Column(name = "user_email", unique = true)
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@OneToMany
	@JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
	private Perfil perfilId;
	
	public Usuario() {
	}

	public Usuario(Integer userId, String userNome, String userEmail, String userPassword, Perfil perfilId) {
		this.userId = userId;
		this.userNome = userNome;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.perfilId = perfilId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNome() {
		return userNome;
	}

	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Perfil getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Perfil perfilId) {
		this.perfilId = perfilId;
	}

	
}
