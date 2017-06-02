package br.com.nf.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.nf.model.vo.NotaFiscal;

public class NotaFiscalDao {
	
	public void inserir(NotaFiscal nota){
		
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(nota);
		em.getTransaction().commit();
		em.close(); 
		
	}
}
