package com.istic.ila.aoc.methodInvocation;

import com.istic.ila.aoc.client.IGenerateur;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class UpdateCallable<T> implements Callable {
	
	private IGenerateur g;
	
	private T value;
	
	public UpdateCallable(T value) {
		this.value = value;
	}
	
	public Future call() {
		return null;
	}
}
