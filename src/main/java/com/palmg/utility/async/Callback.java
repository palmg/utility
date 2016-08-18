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

@FunctionalInterface
/**
 * 异步返回接口，提供所有可异步返回的功能接口
 * @author chkui
 */
public interface Callback<T> {

	/**
	 * 回调接口
	 * @param t 回调传递的内容
	 */
	void call(T t);
}
