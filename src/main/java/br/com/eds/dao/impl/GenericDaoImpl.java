package br.com.eds.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.eds.dao.GenericDao;

public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> clazz;
	

	public GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public List<T> findAll() {
		TypedQuery<T> query = entityManager.createQuery("from " + clazz.getName(), clazz);
		return query.getResultList();
	}

	@Override
	public T findById(Integer id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void persist(T t) {
		entityManager.persist(t);
	}
	
	@Override
	public void update(T t) {
		entityManager.merge(t);
	}

	@Override
	public void remove(T t) {
		entityManager.remove(t);
	}
}
