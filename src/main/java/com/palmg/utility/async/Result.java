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
package com.palmg.utility.async;

/**
 * <h3>异步返回的结果</h3>
 * <p>用isSuccess标记异步返回的结果是否成功，true:处理成功/false处理失败。 如果返回成功，使用getResult可以获取模板指定的数据
 * </p>
 * 
 * @author chkui
 */
public interface Result<T> {
	/**
	 * 标记处理结果是否成功
	 * 
	 * @return true/false
	 */
	boolean isSuccess();

	/**
	 * 获取返回的数据
	 * 
	 * @return 异步调用返回的数据
	 */
	T getResult();

	/**
	 * 获取导致的异常
	 * 
	 * @return 异步调用返回的异常
	 */
	Throwable getCause();
}
