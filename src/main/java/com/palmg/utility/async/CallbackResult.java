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

import com.palmg.utility.async.exception.AsyncRuntimeException;
import com.palmg.utility.async.impl.AyscReturnResult;

public interface CallbackResult<T> extends Callback<Result<T>> {

	default void success() {
		this.call(new AyscReturnResult<T>());
	}

	default void success(T t) {
		this.call(new AyscReturnResult<T>(t));
	}

	default void fail() {
		this.call(new AyscReturnResult<T>(new AsyncRuntimeException("unknown async exception")));
	}

	default void fail(final String errMsg) {
		this.call(new AyscReturnResult<T>(new AsyncRuntimeException(errMsg)));
	}

	default void fail(Throwable tb) {
		this.call(new AyscReturnResult<T>(tb));
	}
}
