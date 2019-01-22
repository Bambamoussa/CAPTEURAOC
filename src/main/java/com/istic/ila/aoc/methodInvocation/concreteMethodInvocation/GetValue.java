package com.istic.ila.aoc.methodInvocation.concreteMethodInvocation;

import com.istic.ila.aoc.client.IGenerateur;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class GetValue<T> implements Callable {
	
	private IGenerateur g;
	
	private T value;
	
	public GetValue(T value) {
		this.value = value;
	}
	
	@Override
	public Future call() {
		return null;
	}
}
