package org.mobile.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;

/**
 * 数据访问接口,提供基本增，删，该，查方法声明以及分页查询方法声明;也是其它数据访问接口父类
 * 
 * @author 孙树林
 * 
 */
public interface IGeneralDao {

	/** sessionFactory */
	public void setSessionFactory(SessionFactory sessionFactory);

	/** session */
	public Session getSession();

	/**
	 * 保存数据
	 */
	public void save(Object value);

	/**
	 * 更新数据
	 */
	public void update(Object value);

	/**
	 * 根据ID查询;从数据库查询记录;
	 * 
	 * @param obj
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class clazz, String id);

	/**
	 * 根据ID查询;返回代理;
	 * 
	 * @param obj
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object load(Class clazz, String id);

	/**
	 * 删除数据
	 * 
	 * @param obj
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public void delete(Class clazz, String id);

	/**
	 * 删除数据
	 * 
	 * @param obj
	 * @param id
	 */
	public void delete(Object obj);

	/**
	 * 批处理插入
	 * 
	 * @param values
	 */
	public void batchingSave(List<Object> values);

	/**
	 * 批处理更新
	 * 
	 * @param values
	 */
	public void batchingUpdate(List<Object> values);

	/**
	 * 批处理删除
	 * 
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	public void batchingDelete(Class clazz, List<String> ids);

	/**
	 * executeUpdate执行HQL语句批处理适用于insert,update,delete
	 * 
	 * @param q
	 */
	public int executeUpdate(Query q);

	/**
	 * 标准分页查询;如果pagebean为null不分页
	 * 
	 * @param clazz
	 * @param searchBeans
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> search(Class clazz, List<SearchBean> searchBeans,
			PageBean pageBean, List<OrderByBean> orderBean);

	/**
	 * 执行hql语句
	 * 
	 * @param hql
	 * @return
	 */
	public int executeHql(String hql);

	/**
	 * 执行hql语句
	 * 
	 * @param hql
	 * @return
	 */
	public int executeHql(String hql, String name, String[] ids);

	public List<Object> select();

	public List<Object> now(String id);

	public List<Object> follow(String id, String[] ids);

	public List<Object> auction(String[] ids);

	public Object getBinding(String id);

	public int countE(String id, String uid);

	public List<Object> search(String hql, String count, PageBean pageBean);

	public Object executeQuery(String hql);

	@SuppressWarnings("unchecked")
	public List executeQueryList(String hql);

	public int countF(String id, String uid);
	
	@SuppressWarnings("unchecked")
	public List searchImages(String id, String table);
}