package com.istic.ila.aoc.proxy.impl;

import com.istic.ila.aoc.client.Generateur;
import com.istic.ila.aoc.future.impl.FutureImpl;
import com.istic.ila.aoc.proxy.Canal;

import java.util.Observable;

public class UpdateCanalImpl implements Canal {
	
	private CanalImpl canal;
	
	public FutureImpl getValue(Generateur g) {
		
		return null;
	}
	
	@Override
	public void update(Observable observable, Object o) {
		canal.update(observable, o);
	}
}
