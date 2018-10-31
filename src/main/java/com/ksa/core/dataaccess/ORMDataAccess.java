package com.ksa.core.dataaccess;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 
 * @author Gaurav Pahwa
 *
 * @param <T>
 */

public class ORMDataAccess extends HibernateDaoSupport implements IDataAccess {

	@Autowired
	public void setSessionFactoryCustom(SessionFactory sessionFactoryCustom) {

		super.setSessionFactory(sessionFactoryCustom);

	}

	
	public <T> void save(T t) {

		getHibernateTemplate().save(t);

	}

	public <T> void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);

	}

	public <T> void delete(T t) {
		getHibernateTemplate().delete(t);

	}
	public <T> void deleteAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}
	public <T> void persist(T t) {
		getHibernateTemplate().persist(t);

	}

	public <T> void update(T t) {
		getHibernateTemplate().update(t);

	}
	
	public <T> void evict(T t) {
		getHibernateTemplate().evict(t);

	}

	public <T> void merge(T t) {
		getHibernateTemplate().merge(t);

	}

	public <T> T load(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	public <T> T get(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	public <T> List<T> loadAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults)
			throws DataAccessException {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

}
