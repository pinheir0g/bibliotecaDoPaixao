package br.org.serratec.bibliotecaPaixao.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private Integer editoraId;

	@Column(name = "nome")
	private Integer nome;

	@Column(name = "imagem_nome")
	private Integer imagemNome;

	@Column(name = "imagem_filename")
	private Integer imagemFilename;

	@Column(name = "imagem_url")
	private Integer imagemUrl;

	@OneToMany(mappedBy="editora")
	private List<Livro> livro;


	public Integer getNome() {
		return nome;
	}

	public void setNome(Integer nome) {
		this.nome = nome;
	}

	public Integer getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(Integer imagemNome) {
		this.imagemNome = imagemNome;
	}

	public Integer getImagemFilename() {
		return imagemFilename;
	}

	public void setImagemFilename(Integer imagemFilename) {
		this.imagemFilename = imagemFilename;
	}

	public Integer getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(Integer imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	public Integer getEditoraId() {
		return editoraId;
	}
}
