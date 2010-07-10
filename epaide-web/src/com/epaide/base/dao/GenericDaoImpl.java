package com.epaide.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.epaide.base.utils.IbatisDaoUtils;

/**
 * 
 * @author paragon
 * 
 * @param <T>
 * @param <PK>
 */
public class GenericDaoImpl<T, PK extends Serializable> extends
		SqlMapClientDaoSupport implements GenericDao<T, PK> {
	private Class<T> persistentClass;

	public GenericDaoImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public boolean exists(PK paramPK) {
		return getSqlMapClientTemplate().queryForObject(
				IbatisDaoUtils.getFindQuery(persistentClass)) != null;
	}

	@Override
	public T get(PK paramPK) {
		return (T) getSqlMapClientTemplate().queryForObject(
				IbatisDaoUtils.getFindQuery(persistentClass));
	}

	@Override
	public List<T> getAll() {
		return getSqlMapClientTemplate().queryForList(
				IbatisDaoUtils.getSelectQuery(persistentClass));
	}

	@Override
	public void remove(PK paramPK) {
		getSqlMapClientTemplate().update(
				IbatisDaoUtils.getDeleteQuery(IbatisDaoUtils
						.getDeleteQuery(persistentClass)), paramPK);
	}

	@Override
	public T save(T paramT) {
		return (T) getSqlMapClientTemplate().insert(
				IbatisDaoUtils.getInsertQuery(persistentClass), paramT);
	}

	@Override
	public void update(T paramT) {
		getSqlMapClientTemplate().update(
				IbatisDaoUtils.getUpdateQuery(persistentClass), paramT);
	}

}
