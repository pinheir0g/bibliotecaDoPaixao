package br.org.serratec.bibliotecaPaixao.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "perfilID", scope = Perfil.class)
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perfil_id")
	private Integer perfilID;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public Perfil(Integer perfilID, String nome, String descricao) {
		this.perfilID = perfilID;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getPerfilID() {
		return perfilID;
	}

	public void setPerfilID(Integer perfilID) {
		this.perfilID = perfilID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Perfil [perfilID=" + perfilID + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
}