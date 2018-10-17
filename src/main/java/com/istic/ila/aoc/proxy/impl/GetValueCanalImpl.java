package com.istic.ila.aoc.proxy.impl;

import com.istic.ila.aoc.future.impl.FutureImpl;
import com.istic.ila.aoc.methodInvocation.Callable;
import com.istic.ila.aoc.proxy.Canal;
import com.istic.ila.aoc.service.impl.GetValueObsGenAsyncImpl;

public class GetValueCanalImpl extends GetValueObsGenAsyncImpl implements Canal {
	
	public FutureImpl getValue() {
		
		return null;
	}
	
	@Override
	public void update() {
	
	}
}
