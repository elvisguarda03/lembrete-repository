package br.com.guacom.lembrete.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("reminder");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
