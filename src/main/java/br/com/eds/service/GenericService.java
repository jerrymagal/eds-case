package br.com.eds.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Serializable> {
	
	List<T> findAll();
	
	T findById(Integer id);

	void persist(T t);
	
	void update(T t);
	
	void remove(T t);
}
