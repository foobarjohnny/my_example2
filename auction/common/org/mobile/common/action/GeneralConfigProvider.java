package org.mobile.common.action;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;

/**
 * struts2配置文件自动加载
 * 
 * @author 孙树林
 * 
 */
public class GeneralConfigProvider extends XmlConfigurationProvider {

	private static final String FILE_PATTERN = "classpath*:/**/struts-*.xml";

	/**
	 * 构造器
	 */
	public GeneralConfigProvider() {
		// 经过测试当使用互联网时可以不用加入以下代码,如果不接入互联网必须加入以下代码
		Map<String, String> mappings = new HashMap<String, String>();
		mappings.put("-//OpenSymphony Group//XWork 2.1.3//EN",
				"xwork-2.1.3.dtd");
		mappings.put("-//OpenSymphony Group//XWork 2.1//EN", "xwork-2.1.dtd");
		mappings.put("-//OpenSymphony Group//XWork 2.0//EN", "xwork-2.0.dtd");
		mappings.put("-//OpenSymphony Group//XWork 1.1.1//EN",
				"xwork-1.1.1.dtd");
		mappings.put("-//OpenSymphony Group//XWork 1.1//EN", "xwork-1.1.dtd");
		mappings.put("-//OpenSymphony Group//XWork 1.0//EN", "xwork-1.0.dtd");
		mappings
				.put(
						"-//Apache Software Foundation//DTD Struts Configuration 2.0//EN",
						"struts-2.0.dtd");
		mappings
				.put(
						"-//Apache Software Foundation//DTD Struts Configuration 2.1//EN",
						"struts-2.1.dtd");
		mappings
				.put(
						"-//Apache Software Foundation//DTD Struts Configuration 2.1.7//EN",
						"struts-2.1.7.dtd");
		setDtdMappings(mappings);
	}

	@Override
	protected Iterator<URL> getConfigurationUrls(String fileName)
			throws IOException {
		List<URL> urls = new ArrayList<URL>();
		Resource[] resources = getAllResourcesUrl();
		for (Resource resource : resources) {
			urls.add(resource.getURL());
		}

		return urls.iterator();
	}

	/**
	 * 获得系统中struts2配置文件
	 * 
	 * @return
	 */
	private Resource[] getAllResourcesUrl() {
		ResourcePatternResolver resoler = new PathMatchingResourcePatternResolver();
		try {
			return resoler.getResources(FILE_PATTERN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Resource[0];
	}
}
