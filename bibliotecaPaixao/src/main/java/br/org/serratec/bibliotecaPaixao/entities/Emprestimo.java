package br.org.serratec.bibliotecaPaixao.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emprestimo_id")
	private Integer emprestimoId;

	@Column(name = "data_emprestimo")
	private LocalDate dataEmprestimo;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "valor_emprestimo")
	private Double valorEmprestimo;

	@ManyToOne
	@JoinColumn(name = "aluno_matricula")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "livro_id", referencedColumnName = "livro_id")
	private Livro livro;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Integer emprestimoId, LocalDate dataEmprestimo, LocalDate dataEntrega, Double valorEmprestimo,
			Aluno aluno, Livro livro) {
		super();
		this.emprestimoId = emprestimoId;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.valorEmprestimo = valorEmprestimo;
		this.aluno = aluno;
		this.livro = livro;
	}

	public Integer getEmprestimoId() {
		return emprestimoId;
	}

	public void setEmprestimoId(Integer emprestimoId) {
		this.emprestimoId = emprestimoId;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(Double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}


}
