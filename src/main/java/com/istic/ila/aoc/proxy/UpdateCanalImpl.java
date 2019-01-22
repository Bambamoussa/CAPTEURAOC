package com.istic.ila.aoc.proxy;

import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.service.ObsGenAsync;

import java.util.concurrent.Future;

public class UpdateCanalImpl implements ObsGenAsync {
	
	private Canal canal;
	
	public void getValue(IGenerateur g) {
	
	}
	
	@Override
	public Future update(IGenerateur generateur) {
		canal.update(generateur);
		return null;
	}
}
