package com.palmg.utility.async;

import java.util.List;

public interface Msg<T> {
	String getAddress();
	
	T getMessage();
	
	List<String> getHeader(String name);
	
	void reply(Object msg);
	
	void fail(String errMsg);
}
