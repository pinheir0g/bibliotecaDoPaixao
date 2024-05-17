package br.org.serratec.bibliotecaPaixao.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "livroId", scope = Livro.class)
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_id")
	private Integer livroId;

	@Column(name = "nome_livro")
	private String nomeLivro;

	@Column(name = "nome_autor")
	private String nomeAutor;

	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;

	@Column(name = "codigo_isbn")
	private Integer codigoIsbn;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos;

	public Livro() {
	}

	public Livro(Integer livroId, String nomeLivro, String nomeAutor, LocalDate dataLancamento, Integer codigoIsbn,
			Editora editora, List<Emprestimo> emprestimos) {
		this.livroId = livroId;
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataLancamento = dataLancamento;
		this.codigoIsbn = codigoIsbn;
		this.editora = editora;
		this.emprestimos = emprestimos;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	@Override
	public String toString() {
		return "Livro{" + "livroId=" + livroId + ", nomeLivro='" + nomeLivro + '\'' + ", nomeAutor='" + nomeAutor + '\''
				+ ", dataLancamento=" + dataLancamento + ", codigoIsbn='" + codigoIsbn + '\'' + ", editora=" + editora
				+ ", emprestimos=" + emprestimos + '}';
	}
}
