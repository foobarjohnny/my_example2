package ilife.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 实现常用CRUD POJOS的基本DAO (Data Access Object)
 * 
 * @author newman
 * @param <T>
 *            POJO类型
 * @param <PK>
 *            POJO类型的主键
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * 取得所有记录.
	 */
	List<T> getAll();

	/**
	 * 取得所有没有重复的记录.
	 * <p>
	 * 子类实例化请实现 hashcode/equals方法
	 * </p>
	 * 
	 */
	List<T> getAllDistinct();

	/**
	 * 根据逐渐取得对象信息. 如果不存在，一个运行时异常EntityNotFoundException会被抛出.
	 * 
	 * @param id
	 *            主键
	 * @return 试题对象
	 * @see javax.persistence.EntityNotFoundException
	 */
	T get(PK id);

	/**
	 * 根据主键id判断对象是否存在.
	 * 
	 * @param id
	 *            实体主键
	 */
	boolean exists(PK id);

	/**
	 * 持久化对象的基本方法 - 处理更新和插入.
	 * 
	 * @param object
	 * 
	 * @return 保存后的对象
	 */
	T save(T object);

	/**
	 * 基于主键删除对象
	 * 
	 * @param id
	 *           
	 */
	void remove(PK id);
}