package ilife.common.dao.impl;

import ilife.common.dao.GenericDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 所有DAO的基类 -
 * 
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Entity manager, injected by Spring using @PersistenceContext annotation
	 * on setEntityManager()
	 */
	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> persistentClass;

	/**
	 * 
	 * @param persistentClass
	 *            将要持久化的对象
	 */
	public GenericDaoImpl(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * @param persistentClass
	 *            将要持久化的对象
	 * @param entityManager
	 * 
	 */
	public GenericDaoImpl(final Class<T> persistentClass, EntityManager entityManager) {
		this.persistentClass = persistentClass;
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.entityManager.createQuery(
				"select obj from " + this.persistentClass.getName() + " obj").getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		T entity = this.entityManager.find(this.persistentClass, id);

		if (entity == null) {
			String msg = "Uh oh, '" + this.persistentClass + "' object with id '" + id
					+ "' not found...";
			log.warn(msg);
			throw new EntityNotFoundException(msg);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		T entity = this.entityManager.find(this.persistentClass, id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public T save(T object) {
		return this.entityManager.merge(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		this.entityManager.remove(this.get(id));
	}
}
