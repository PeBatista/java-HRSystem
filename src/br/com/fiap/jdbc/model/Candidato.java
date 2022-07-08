package br.com.fiap.jdbc.model;

import java.sql.Date;

public class Candidato {
	private int idCandidato;
	private String nome;
	private Date dataNasc;
	private String genero;
	private float tempoExperiencia;
	private String formacao;
	private String telefone;
	private String email;
	private String endereco;
	private int idArea;
	
	public Candidato(int idCandidato, String nome, Date dataNasc, String genero, float tempoExperiencia,
			String formacao, String telefone, String email, String endereco,int idArea) {
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
		this.tempoExperiencia = tempoExperiencia;
		this.formacao = formacao;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.idArea = idArea;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(float tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	
	
	
}
