package org.tctam.spring.boilerplate.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.tctam.spring.boilerplate.daos.DAO;

@SuppressWarnings("unchecked")
public abstract class HibernateDAO<T extends Serializable, ID extends Serializable> implements DAO<T, ID> {

	private Class<T> persistentClass;
	private SessionFactory sessionFacetory;

	public HibernateDAO(SessionFactory sessionFactory) {
		this.sessionFacetory = sessionFactory;
		Class klass = getClass();
		while (klass != null && !(klass.getGenericSuperclass() instanceof ParameterizedType)) {
			klass = klass.getSuperclass();
		}
		persistentClass = (Class<T>) ((ParameterizedType) klass.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFacetory.getCurrentSession();
	}

	protected Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public List<T> findAll() {
		return getSession().createCriteria(persistentClass).list();
	}

	@Override
	public T findById(ID id) {
		return (T) getSession().load(persistentClass, id);
	}

	@Override
	public T getById(ID id) {
		return (T) getSession().get(persistentClass, id);
	}

	@Override
	public T save(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public long deleteAll() {
		return getSession().createQuery("delete from " + getPersistentClass().getName()).executeUpdate();
	}

}
