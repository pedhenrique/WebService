package br.com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.dao.TimeDAO;
import br.com.entidades.Time;

@Path("/time")
@Stateless
public class TimeResource {
	
	@EJB
	private TimeDAO timeDAO;
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Time buscarTime(@PathParam("id") int id){
		Time time = timeDAO.buscar(id);
		
		return time;
	}
	
	@GET
	@Produces("application/json")
	public List<Time> listarTimes(){
		List<Time> lista = timeDAO.listar(); 
		return lista;
	}
}
