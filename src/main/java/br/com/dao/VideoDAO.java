package br.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidades.Video;

@Stateless
public class VideoDAO {

	@PersistenceContext(name = "TestePU")
	private EntityManager em;
	
	public List<Video> listar(){
		List<Video> lista = null;
		
		try {
			TypedQuery<Video> query  = em.createNamedQuery("consulta.listarTodosVideos", Video.class);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Video buscar(int id){
		Video video  = null;
		
		try {
			video = em.find(Video.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return video;
	}
}
