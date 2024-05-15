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

	@ManyToOne
	@JoinColumn(name = "aluno_matricula")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Integer livroId;

	@Column(name = "data_emprestimo")
	private LocalDate dataEmprestimo;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "valor_emprestimo")
	private Double valorEmprestimo;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Integer emprestimoId, Aluno aluno, Integer livroId, LocalDate dataEmprestimo,
			LocalDate dataEntrega, Double valorEmprestimo) {
		super();
		this.emprestimoId = emprestimoId;
		this.aluno = aluno;
		this.livroId = livroId;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.valorEmprestimo = valorEmprestimo;
	}

	public Integer getEmprestimoId() {
		return emprestimoId;
	}

	public void setEmprestimoId(Integer emprestimoId) {
		this.emprestimoId = emprestimoId;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAlunoMatricula(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
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
}
