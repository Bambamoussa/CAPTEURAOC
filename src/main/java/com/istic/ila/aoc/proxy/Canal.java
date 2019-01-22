package com.istic.ila.aoc.proxy;

import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.service.GenAsync;
import com.istic.ila.aoc.service.ObsGenAsync;

import java.util.concurrent.Future;

public class Canal implements ObsGenAsync, GenAsync {
	
	private long time = 0;
	
	public Future update(IGenerateur generateur) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Future getValue() {
		return null;
	}
}
