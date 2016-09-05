/*
 * Copyright palmg(www.palmg.com)
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of Apache License v2.0 which accompanies this distribution.
 * 
 *     The Apache License v2.0 is available at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * You may elect to redistribute this code under this licenses and copyright.
 * ------------------------------------------------------
 */
package com.palmg.utility.properties;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 全局Properties加载工具
 * 
 * @author chkui
 */
public class PropertiesLoadUtil {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesLoadUtil.class);

	private PropertiesLoadUtil() {
	}

	/**
	 * 获取propertis,并返回key对应的值
	 * @param classPath
	 * @param key
	 * @return
	 */
	public static String classPathLoad(final String classPath, final String key) {
		return classPathLoad(classPath).getProperty(key);
	}

	/**
	 * 从classPath加载properties
	 * 
	 * @param classPath
	 * @return
	 */
	public static Properties classPathLoad(final String classPath) {
		Properties p = null;
		try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPath)) {
			if (null != in) {
				p = new Properties();
				p.load(in);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOG.error("load properties" + classPath + "error", e);
		}
		return p;
	}
}
