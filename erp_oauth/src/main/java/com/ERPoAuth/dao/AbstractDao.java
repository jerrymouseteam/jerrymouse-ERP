package com.ERPoAuth.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Session getOpenSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(long bankId) {
		return (T) getSession().get(persistentClass, bankId);
	}

	public Long saveEntity(T entity) {

		Session session = getOpenSession();
		Transaction tx = session.beginTransaction();
		Long id = null;
		try {

			id = (Long) session.save(entity);
			System.out.println("**************** Save Return Id " + id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

			session.close();
		}
		return id;

	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void updateEntity(T entity) {

		Session session = getOpenSession();
		Transaction tx = session.beginTransaction();

		try {

			session.update(entity);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

			session.close();
		}

	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}

	protected Criteria createEntityCriteria() {

		return getSession().createCriteria(persistentClass);
	}

}
