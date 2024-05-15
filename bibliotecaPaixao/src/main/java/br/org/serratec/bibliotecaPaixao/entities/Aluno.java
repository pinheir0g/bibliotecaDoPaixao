package br.org.serratec.bibliotecaPaixao.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.aluno")
public class Aluno {

	@Id
	@Column(name = "aluno_matricula")
	private Integer aluno_matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "dat_anascimento")
	private Date data_nascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero_logradouro")
	private String numero_logadouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	
	public Aluno() {
		super();
	}

	public Aluno(int aluno_matricula, String nome, Date data_nascimento, String cpf, String logradouro,
			String numero_logadouro, String complemento, String bairro, String cidade) {
		super();
		this.aluno_matricula = aluno_matricula;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero_logadouro = numero_logadouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getAluno_matricula() {
		return aluno_matricula;
	}

	public void setAluno_matricula(Integer aluno_matricula) {
		this.aluno_matricula = aluno_matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
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

	public String getNumero_logadouro() {
		return numero_logadouro;
	}

	public void setNumero_logadouro(String numero_logadouro) {
		this.numero_logadouro = numero_logadouro;
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
