package br.com.eds.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.eds.dao.GenericDao;

public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<T> clazz;
	

	public GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public List<T> findAll() {
		TypedQuery<T> query = em.createQuery("from " + clazz.getName(), clazz);
		return query.getResultList();
	}

	@Override
	public T findById(Integer id) {
		return em.find(clazz, id);
	}

	@Override
	public void persist(T t) {
		em.persist(t);
	}
	
	@Override
	public void update(T t) {
		em.merge(t);
	}

	@Override
	public void remove(T t) {
		em.remove(em.contains(t) ? t : em.merge(t));
	}
}
