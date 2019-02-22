package br.com.guacom.lembrete.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.guacom.lembrete.model.Lembrete;
import br.com.guacom.lembrete.util.JPAUtil;

public class LembreteDAO {
	private EntityManager entity;
	
	public LembreteDAO() {
	}
	
	public void persist(Lembrete lembrete) {
		entity = new JPAUtil().getEntityManager();
		entity.getTransaction().begin();
		entity.persist(lembrete);
		entity.getTransaction().commit();
		entity.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Lembrete> findAll() {
		entity = new JPAUtil().getEntityManager();
		entity.getTransaction().begin();
		List<Lembrete> lembretes = entity.createQuery("FROM " + Lembrete.class.getName()).getResultList();
		entity.close();
		return lembretes;
	}
	
	public void merge(Lembrete lembrete) {
		entity = new JPAUtil().getEntityManager();
		entity.getTransaction().begin();
		entity.merge(lembrete);
		entity.getTransaction().commit();
		entity.close();
	}
	
	public Lembrete getById(final int id) {
		entity = new JPAUtil().getEntityManager();
		Lembrete find = entity.find(Lembrete.class, id);
		entity.close();
		return find;
	}
	
	public void remove(Lembrete lembrete) {
		entity = new JPAUtil().getEntityManager();
		entity.getTransaction().begin();
		entity.remove(entity.merge(lembrete));
		entity.getTransaction().commit();
		entity.close();
	}
}