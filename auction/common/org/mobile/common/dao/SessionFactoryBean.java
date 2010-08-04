package org.mobile.common.dao;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

/**
 * LocalSessionFactoryBean扩展类，实现自动加载hibernate配置文件
 * 
 * @author 孙树林
 * 
 */
public class SessionFactoryBean extends LocalSessionFactoryBean {

	private static final String FILE_PATTERN = "classpath*:/**/*.hbm.xml";

	/**
	 * 自动加入类路径中所有匹配的Hibernate映射文件;hibernate配置文件无需加入到配置文件中;否则会失败
	 */
	protected void postProcessConfiguration(Configuration config)
			throws HibernateException {
		ResourcePatternResolver resoler = new PathMatchingResourcePatternResolver();
		Resource[] resources;
		try {
			resources = resoler.getResources(FILE_PATTERN);
			for (int i = 0; i < resources.length; i++) {
				Resource resource = resources[i];
				if (resource.exists())
					config.addInputStream(resource.getInputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.postProcessConfiguration(config);
	}
}
