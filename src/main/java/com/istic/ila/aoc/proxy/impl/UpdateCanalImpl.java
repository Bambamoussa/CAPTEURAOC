package com.istic.ila.aoc.proxy.impl;

import com.istic.ila.aoc.client.Generateur;
import com.istic.ila.aoc.future.impl.FutureImpl;
import com.istic.ila.aoc.methodInvocation.Callable;
import com.istic.ila.aoc.proxy.Canal;
import com.istic.ila.aoc.service.impl.UpdateObsGenAsyncImpl;

public class UpdateCanalImpl extends UpdateObsGenAsyncImpl implements Canal {
	
	public FutureImpl update(Generateur g) {
		
		return null;
	}
	
	@Override
	public void update() {
	
	}
}
