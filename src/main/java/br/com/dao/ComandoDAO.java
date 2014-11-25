package br.com.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.entidades.Comando;


@Stateless
public class ComandoDAO {
	
	@PersistenceContext(name = "TestePU")
	private EntityManager em;
	
	public Comando buscar(){
		Comando comando = null;
		
		try {
			comando = em.find(Comando.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return comando;
	}
	
	public void atualizar(Comando comando){
		try {
			em.merge(comando);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
//		TypedQuery<Comando> query  = em.createNamedQuery("atualizarComando", Comando.class);	
//		query.executeUpdate();
	}	
}
