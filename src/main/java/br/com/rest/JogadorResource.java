package br.com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.dao.JogadorDAO;
import br.com.entidades.Jogador;

@Path("/jogador")
@Stateless
public class JogadorResource {
	
	@EJB
	private JogadorDAO jogadorDAO;
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Jogador buscarJogador(@PathParam("id") int id){
		Jogador jogador = jogadorDAO.buscar(id); 
		return jogador;
	}
	
	@GET
	@Produces("application/json")
	public List<Jogador> listarJogadores(){
		List<Jogador> lista = jogadorDAO.listar(); 
		return lista;
	}

}
