package com.istic.ila.aoc.methodInvocation.concreteMethodInvocation;

import com.istic.ila.aoc.client.IGenerateur;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update<T> implements Callable {
	
	private IGenerateur g;
	
	private T value;
	
	public Update(T value) {
		this.value = value;
	}
	
	public Future call() {
		return null;
	}
}
