package com.ksa.core.dataaccess;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

public interface IDataAccess  {

	/*
	 * 
	 */
	<T> void save(T t);
	/*
	 * 
	 */
	<T> void saveOrUpdate(T t);
	/*
	 * 
	 */
	<T> void delete(T t);
	/*
	 * 
	 */
	<T> void persist(T t);
	/*
	 * 
	 */
	<T> void update(T t);
	/*
	 * 
	 */
	
	 <T> void evict(T t);
	 
	/*
	 * 
	 */
	<T> T load(Class<T> entityClass,Serializable id);
	
	/*
	 * 
	 */
	<T> T get(Class<T> entityClass,Serializable id);
	
	/**
	 * 
	 * @param entityClass
	 * @return
	 */
	<T> List<T> loadAll(Class<T> entityClass);
	
	/*
	 * 
	 */
	List<?> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) throws DataAccessException;
	
	
}
