package br.com.diego.nf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoNotaFiscal {
	public void insira(NotaFiscal nota){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(nota);

		em.getTransaction().commit();
		em.close();
	}
}
