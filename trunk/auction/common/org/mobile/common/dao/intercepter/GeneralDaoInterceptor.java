package org.mobile.common.dao.intercepter;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.mobile.common.bean.SqlBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.pojo.TsDbLog;
import org.mobile.common.pojo.TsSystemLog;

/**
 * hibernate拦截器主要完成日志记录
 * 
 * @author 孙树林
 * 
 */
public class GeneralDaoInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 5254987876542495265L;

	public void afterTransactionBegin(Transaction transaction) {
	}

	public void afterTransactionCompletion(Transaction transaction) {
	}

	public void beforeTransactionCompletion(Transaction transaction) {
	}

	public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2,
			Object[] arg3, String[] arg4, Type[] arg5) {
		return null;
	}

	public Object getEntity(String arg0, Serializable arg1)
			throws CallbackException {
		return null;
	}

	public String getEntityName(Object arg0) throws CallbackException {
		return null;
	}

	public Object instantiate(String arg0, EntityMode arg1, Serializable arg2)
			throws CallbackException {
		return null;
	}

	public Boolean isTransient(Object arg0) {
		return null;
	}

	public void onCollectionRecreate(Object arg0, Serializable arg1)
			throws CallbackException {
	}

	public void onCollectionRemove(Object arg0, Serializable arg1)
			throws CallbackException {
	}

	public void onCollectionUpdate(Object arg0, Serializable arg1)
			throws CallbackException {
	}

	public void onDelete(Object entity, Serializable id, Object[] parameters,
			String[] propertyNames, Type[] types) throws CallbackException {
		if (entity instanceof TsSystemLog || entity instanceof TsDbLog) {

		} else {
			GeneralManager manager = GeneralManager.getCurrentManager();
			SqlBean sqlBean = new SqlBean();
			manager.getSqlBeans().add(sqlBean);
			sqlBean.setId(String.valueOf(id));
			sqlBean.setParameter(parameter(propertyNames, parameters));
			sqlBean.setSql(SqlBean.DLETE);
		}
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] parameters, Object[] arg3, String[] propertyNames,
			Type[] types) throws CallbackException {
		if (entity instanceof TsSystemLog || entity instanceof TsDbLog) {

		} else {
			GeneralManager manager = GeneralManager.getCurrentManager();
			SqlBean sqlBean = new SqlBean();
			manager.getSqlBeans().add(sqlBean);
			sqlBean.setId(String.valueOf(id));
			sqlBean.setParameter(parameter(propertyNames, parameters));
			sqlBean.setSql(SqlBean.UPDATE);
		}
		return false;
	}

	public boolean onLoad(Object entity, Serializable id, Object[] parameters,
			String[] propertyNames, Type[] types) throws CallbackException {
		return false;
	}

	/**
	 * 执行SQL语句
	 */
	public String onPrepareStatement(String sql) {
		return sql;
	}

	/**
	 * 记录插入操作日志信息
	 */
	public boolean onSave(Object entity, Serializable id, Object[] parameters,
			String[] propertyNames, Type[] types) throws CallbackException {
		if (entity instanceof TsSystemLog || entity instanceof TsDbLog) {

		} else {
			GeneralManager manager = GeneralManager.getCurrentManager();
			SqlBean sqlBean = new SqlBean();
			manager.getSqlBeans().add(sqlBean);
			sqlBean.setId(String.valueOf(id));
			sqlBean.setParameter(parameter(propertyNames, parameters));
			sqlBean.setSql(SqlBean.INSERT);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public void postFlush(Iterator arg0) throws CallbackException {

	}

	@SuppressWarnings("unchecked")
	public void preFlush(Iterator arg0) throws CallbackException {

	}

	/**
	 * 生成参数对
	 * 
	 * @param propertyNames
	 * @param parameters
	 * @return
	 */
	private String parameter(String[] propertyNames, Object[] parameters) {
		String parameter = "";
		for (int i = 0; i < propertyNames.length; i++) {
			parameter = parameter + propertyNames[i] + "=";
			if (parameters != null) {
				parameter = parameter + parameters[i] + ";";
			} else {
				parameter = parameter + "null" + ";";
			}
		}
		return parameter;
	}
}
