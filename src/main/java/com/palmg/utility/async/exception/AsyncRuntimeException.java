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
package com.palmg.utility.async.exception;

/**
 * 异步数据在传递过程中的处理异常
 * 
 * @author chkui
 */
public class AsyncRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -4816484793368338822L;

	public AsyncRuntimeException(String msg) {
		super(msg);
	}
}
