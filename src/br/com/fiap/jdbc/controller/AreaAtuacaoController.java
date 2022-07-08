package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.dao.AreaAtuacaoDAO;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class AreaAtuacaoController {
	
	private AreaAtuacaoDAO areadao;
	
	public AreaAtuacaoController() {
		Connection connection = new ConnectionFactory().conectar();
		this.areadao = new AreaAtuacaoDAO(connection);
	}
	
	public void listarPorCandidato(int id) throws SQLException {
		List<AreaAtuacao> areas = this.areadao.listarComCandidato();
		
		for(AreaAtuacao areaatuacao:areas) {
			System.out.println(areaatuacao.getNome());
		}
		
	}
	
}
