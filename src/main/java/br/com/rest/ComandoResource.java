package br.com.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.dao.ComandoDAO;
import br.com.entidades.Comando;

@Path("/comando")
@Stateless
public class ComandoResource {
	@EJB
	private ComandoDAO comandoDAO;
	
	@GET
	@Path("/produzirVideo")
	public void atualizar() throws IOException{
		Comando comando = new Comando();
		comando.setId(1);
		comando.setComando(true);
		comandoDAO.atualizar(comando);
		Runtime.getRuntime().exec("rm 1.avi");
	}

	@GET
	public String oi(){
		
		return "Oi!";
	}
}
