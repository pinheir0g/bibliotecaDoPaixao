package br.org.serratec.bibliotecaPaixao.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "alunoMatricula", scope = Aluno.class)
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_matricula")
	private Integer alunoMatricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero_logradouro")
	private String numeroLogadouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;
	
	@OneToMany(mappedBy="aluno")
	private List<Emprestimo> emprestimos;

	public Aluno() {
		super();
	}

	public Aluno(int alunoMatricula, String nome, LocalDate dataNascimento, String cpf, String logradouro,
			String numeroLogadouro, String complemento, String bairro, String cidade) {
		super();
		this.alunoMatricula = alunoMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numeroLogadouro = numeroLogadouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getAlunoMatricula() {
		return alunoMatricula;
	}

	public void setAlunoMatricula(Integer alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogadouro() {
		return numeroLogadouro;
	}

	public void setNumeroLogadouro(String numero_logadouro) {
		this.numeroLogadouro = numero_logadouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
