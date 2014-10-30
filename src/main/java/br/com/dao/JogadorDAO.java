package br.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidades.Jogador;

@Stateless
public class JogadorDAO {
	
	@PersistenceContext(name = "TestePU")
	private EntityManager em;
	
	public List<Jogador> listar(){
		List<Jogador> lista = null;
		
		try {
			TypedQuery<Jogador> query  = em.createNamedQuery("consulta.listarTodosJogadores", Jogador.class);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Jogador buscar(int id){
		Jogador jogador  = null;
		
		try {
			jogador = em.find(Jogador.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return jogador;
	}
}
