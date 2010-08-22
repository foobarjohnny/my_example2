package org.mobile.common.dao.impl;

import java.util.Date;
import java.util.List;

import org.auction.entity.TsCommodity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.dao.IGeneralDao;
import org.mobile.common.util.TypeConvert;

/**
 * IGeneralDao数据访问接口实现类;其它数据访问类都继承该类;
 * 
 * @author 孙树林
 * 
 */
public class GeneralDaoImpl implements IGeneralDao {

	private SessionFactory sessionFactory;

	/**
	 * 获得sessionFactory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public void delete(Class clazz, String id) {
		getSession().delete(load(clazz, id));
	}

	public void delete(Object obj) {
		getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public Object get(Class clazz, String id) {
		return getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public Object load(Class clazz, String id) {
		return getSession().load(clazz, id);
	}

	public void save(Object value) {
		getSession().save(value);
	}

	public void update(Object value) {
		getSession().update(value);
	}

	public void batchingSave(List<Object> values) {
		for (int i = 0; i < values.size(); i++) {
			getSession().save(values.get(i));
			if (i % 30 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	public void batchingUpdate(List<Object> values) {
		for (int i = 0; i < values.size(); i++) {
			getSession().update(values.get(i));
			if (i % 30 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void batchingDelete(Class clazz, List<String> ids) {
		for (int i = 0; i < ids.size(); i++) {
			delete(clazz, ids.get(i));
			if (i % 30 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	public int executeUpdate(Query q) {
		return q.executeUpdate();
	}

	public int executeHql(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Object> search(Class clazz, List<SearchBean> searchBeans,
			PageBean pageBean, List<OrderByBean> orderBean) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (searchBeans != null && searchBeans.size() > 0) {
			setCondition(criteria, searchBeans);
		}
		setOrdering(criteria, orderBean);
		if (pageBean != null) {
			int totalRec = totalRecoderCount(clazz, searchBeans, orderBean);
			pageBean.setTotalRec(totalRec);
			pageBean.setPage();
			criteria.setFirstResult(pageBean.getStartRow());
			criteria.setMaxResults(pageBean.getPageRec());
		}
		return criteria.list();
	}

	/**
	 * 统计记录数
	 * 
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int totalRecoderCount(Class clazz, List<SearchBean> searchBeans,
			List<OrderByBean> orderBean) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (searchBeans != null && searchBeans.size() > 0) {
			setCondition(criteria, searchBeans);
		}
		setOrdering(criteria, orderBean);
		criteria.setProjection((Projections.rowCount()));
		int countRec = (Integer) criteria.list().get(0);
		return countRec;
	}

	/**
	 * 组合查询条件
	 * 
	 * @param criteria
	 */
	protected void setCondition(Criteria criteria, List<SearchBean> searchBeans) {
		getLinked(criteria, searchBeans);
		for (SearchBean searchBean : searchBeans) {
			if (searchBean.getValue() != null
					&& !searchBean.getValue().equals("")) {
				Object value = TypeConvert.convert(searchBean.getType(),
						searchBean.getValue());
				if (searchBean.getSignl().equals("like")) {
					criteria.add(Restrictions.like(searchBean.getFieldName(),
							"%" + value + "%"));
				} else if (searchBean.getSignl().equals("eq")) {
					criteria.add(Restrictions.eq(searchBean.getFieldName(),
							value));
				} else if (searchBean.getSignl().equals("lt")) {
					criteria.add(Restrictions.lt(searchBean.getFieldName(),
							value));
				} else if (searchBean.getSignl().equals("gt")) {
					criteria.add(Restrictions.gt(searchBean.getFieldName(),
							value));
				} else if (searchBean.getSignl().equals("ge")) {
					criteria.add(Restrictions.ge(searchBean.getFieldName(),
							value));
				} else if (searchBean.getSignl().equals("le")) {
					criteria.add(Restrictions.le(searchBean.getFieldName(),
							value));
				} else if (searchBean.getSignl().equals("neq")) {
					criteria.add(Restrictions.not(Restrictions.eq(searchBean
							.getFieldName(), value)));
				} else if (searchBean.getSignl().equals("null")) {
					criteria
							.add(Restrictions.isNull(searchBean.getFieldName()));
				} else if (searchBean.getSignl().equals("notnull")) {
					criteria.add(Restrictions.isNotNull(searchBean
							.getFieldName()));
				}
			}
		}
	}

	/**
	 * 组合排序
	 * 
	 * @param criteria
	 */
	protected void setOrdering(Criteria criteria, List<OrderByBean> orderBean) {
		if (orderBean != null && orderBean.size() > 0) {
			for (OrderByBean bean : orderBean) {
				if (bean.getSigln().equals("desc")) {
					criteria.addOrder(Order.desc(bean.getFieldName()));
				} else {
					criteria.addOrder(Order.asc(bean.getFieldName()));
				}
			}
		}
	}

	/**
	 * 关联查询
	 * 
	 * @param searchBeans
	 * @return
	 */
	private void getLinked(Criteria criteria, List<SearchBean> searchBeans) {
		for (SearchBean searchBean : searchBeans) {
			if (searchBean.getValue() != null
					&& !searchBean.getValue().equals("")) {
				int index = searchBean.getFieldName().indexOf(".");
				if (index != -1) {
					String[] split = searchBean.getFieldName().split("\\.");
					criteria.createAlias(split[0], split[0]);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> select() {
		Query query = getSession()
				.createQuery(
						"from TsCommodity c where c.state != '3' and c.tsRebotcoms not in (from TsRebotcom r where r.tsCommodity != c)");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object> now(String id) {
		//String hql = "select c from TsCommodity c left join c.tsBiddings b where c.state = '1' and b.tsUser.id = :id";
		String hql = "select c from TsCommodity c where c.state = '1' and :id in (select b.tsUser.id from c.tsBiddings b )";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object> now(String id, PageBean pageBean) {
		String hql = "select c from TsCommodity c left join c.tsBiddings b where c.state = '1' and b.tsUser.id = :id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.setFirstResult((pageBean.getCurrentPage() - 1)
				* pageBean.getPageRec());
		query.setMaxResults(pageBean.getPageRec());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object> follow(String id, String[] ids) {
		String hql = "from TsCommodity c left join c.tsBiddings b where b.tsUser.id = :id and c.id not in (:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.setParameterList("ids", ids);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object> auction(String[] ids) {
		if (ids != null) {
			Criteria criteria = getSession().createCriteria(TsCommodity.class);
			criteria.add(Restrictions.le("starttime", new Date()));
			criteria.add(Restrictions.not(Restrictions.in("state",
					new String[] { "2", "3" })));
			criteria.add(Restrictions.not(Restrictions.in("id", ids)));
			// String hql =
			// "from TsCommodity where id not in (:ids) and starttime >= :starttime and state != '2' and state != '3'";
			// Query query = getSession().createQuery(hql);
			// query.setDate("starttime", new Date());
			// query.setParameterList("ids", ids);
			return criteria.list();
		} else {
			Criteria criteria = getSession().createCriteria(TsCommodity.class);
			criteria.add(Restrictions.le("starttime", new Date()));
			criteria.add(Restrictions.not(Restrictions.in("state",
					new String[] { "2", "3" })));
			// String hql =
			// "from TsCommodity where  starttime >= :starttime and state != '2' and state != '3'";
			// Query query = getSession().createQuery(hql);
			// query.setDate("starttime", new Date());
			return criteria.list();
		}
	}

	public Object getBinding(String id) {
		String hql = "from TsBidding t where t.tsCommodity.id = :id and isbid='1'";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		return query.uniqueResult();
	}

	public int countE(String id, String uid) {
		String hql = "select count(id) from TsBidding t where t.tsCommodity.id = :id and t.tsUser.id=:uid";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("uid", uid);
		Object obj = query.uniqueResult();
		if (obj != null) {
			return Integer.parseInt(String.valueOf(obj));
		} else {
			return 0;
		}
	}

}
