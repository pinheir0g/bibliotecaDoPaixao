package br.org.serratec.bibliotecaPaixao.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "editoraId", scope = Editora.class)
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private Integer editoraId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "imagem_nome")
	private String imagemNome;

	@Column(name = "imagem_filename")
	private String imagemFilename;

	@Column(name = "imagem_url")
	private String imagemUrl;

	@OneToMany(mappedBy = "editora", fetch = FetchType.EAGER)
	private List<Livro> livro;

	public Editora() {

	}

	public Editora(Integer editoraId, String nome, String imagemNome, String imagemFilename, String imagemUrl,
			List<Livro> livro) {
		this.editoraId = editoraId;
		this.nome = nome;
		this.imagemNome = imagemNome;
		this.imagemFilename = imagemFilename;
		this.imagemUrl = imagemUrl;
		this.livro = livro;
	}

	public Integer getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFilename() {
		return imagemFilename;
	}

	public void setImagemFilename(String imagemFilename) {
		this.imagemFilename = imagemFilename;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}


}
