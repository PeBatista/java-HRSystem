package br.com.fiap.jdbc.testes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.jdbc.controller.AreaAtuacaoController;
import br.com.fiap.jdbc.controller.CandidatoController;
import br.com.fiap.jdbc.dao.AreaAtuacaoDAO;
import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.model.Candidato;

public class testes {

	public static void main(String[] args) throws SQLException {
		Calendar hoje = Calendar.getInstance();
		Date data = new Date(hoje.getTimeInMillis());
		CandidatoDAO candidatodao = new CandidatoDAO(null);		
		Candidato pedro = new Candidato(0, "Pedro Batista", data, "Masculino", 3, "Técnico de redes", "11983804492", "pedrobatista242526@gmail.com", "rua zike tuma", 4);
		
		
		
		try {
			candidatodao.insert(pedro);
		} catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

}
