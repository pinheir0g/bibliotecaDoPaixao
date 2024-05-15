package br.org.serratec.bibliotecaPaixao.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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
	private String codigoIsbn;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	@OneToMany
	private List<Emprestimo> emprestimos;

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

	public String getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(String codigoIsbn) {
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
