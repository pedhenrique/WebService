package br.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidades.Time;

@Stateless
public class TimeDAO {
	
	@PersistenceContext(name = "TestePU")
	private EntityManager em;
	
	public Time buscar(int id){
		Time time = null;
		try {
			time = em.find(Time.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	public List<Time> listar(){
		List<Time> lista = null;
		try {
			TypedQuery<Time> query = em.createNamedQuery("consulta.listarTodosTimes", Time.class);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
