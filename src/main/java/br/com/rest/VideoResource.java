package br.com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.dao.VideoDAO;
import br.com.entidades.Video;

@Path("/video")
@Stateless
public class VideoResource {
	@EJB
	private VideoDAO videoDAO;
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Video buscarVideo(@PathParam("id") int id){
		Video video = videoDAO.buscar(id); 
		return video;
	}
	
	@GET
	@Produces("application/json")
	public List<Video> listarVideo(){
		List<Video> lista = videoDAO.listar(); 
		return lista;
	}
}
