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
package com.palmg.utility.async.impl;

import com.palmg.utility.async.Result;

/**
 * <h3>异步返回数据的实体类</h3>
 * <p>
 * 对象提供了2个构造函数。当执行成功时，使用AyscReurnResult(T t)来返回成功数据或使用AyscReurnResult()来表达执行成功。
 * </p>
 * <p>
 * 当执行失败时使用，使用AyscReurnResult(Throwable ex)来表述执行失败
 * </p>
 * @author chkui
 */
public class AyscReturnResult<T> implements Result<T> {

	/**
	 * 数据项目
	 */
	private T t;
	
	private Throwable exception;
	
	private boolean isSuc;
	
	/**
	 * 执行成功但不构建数据，说明某些处理成功完成
	 */
	public AyscReturnResult(){
		isSuc = true;
	}

	/**
	 * 执行成功时返回数据
	 * @param t 要返回给调用者的数据
	 */
	public AyscReturnResult(T t){
		isSuc = true;
		this.t = t;
	}
	
	/**
	 * 执行失败时返回异常
	 * @param ex 要返回给调用者的异常信息
	 */
	public AyscReturnResult(Throwable ex){
		this.exception = ex;
		isSuc = false;
	}
	
	@Override
	public boolean isSuccess() {
		return isSuc;
	}

	@Override
	public T getResult() {
		return t;
	}

	@Override
	public Throwable getCause() {
		return exception;
	}
}
