package br.com.eds.service.impl;

import java.io.Serializable;
import java.util.List;

import br.com.eds.dao.GenericDao;
import br.com.eds.service.GenericService;

public abstract class GenericServiceImpl<T extends Serializable> implements GenericService<T> {
	
	@Override
	public T findById(Integer id) {
		return getDao().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public void persist(T t) {
		getDao().persist(t);
	}
	
	@Override
	public void update(T t) {
		getDao().update(t);
	}

	@Override
	public void remove(T t) {
		getDao().remove(t);
	}
	
	abstract GenericDao<T> getDao();

}
