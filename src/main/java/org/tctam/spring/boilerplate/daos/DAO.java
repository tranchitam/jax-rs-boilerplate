package org.tctam.spring.boilerplate.daos;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable, ID extends Serializable> {
	public List<T> findAll();

	public T findById(ID id);
	
	public T getById(ID id);

	public T save(T entity);

	public T update(T entity);

	public void delete(T entity);

	public long deleteAll();
}
