package com.carledwinj.util;

import java.io.Serializable;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;
	
	public <T> Serializable create(final T entity){
		return sessionFactory.getCurrentSession().save(entity);
	}
	
	public <T> T update(final T entity){
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}
	
	public <T> void delete(final T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public <T> void delete(Serializable id, Class<T> entityClass){
		T entity = fetchById(entityClass, id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T fetchById(Class<T> entityClass, Serializable id){
		return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}
	
	@SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query){
		return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}
	
	@SuppressWarnings("rawtypes")
	public <T>List fetchAll(Class<T> entityClass){
		return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).list();
	}
}
