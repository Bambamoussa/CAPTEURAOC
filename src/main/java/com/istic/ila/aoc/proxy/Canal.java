package com.istic.ila.aoc.proxy;

import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.service.GenAsync;
import com.istic.ila.aoc.service.ObsGenAsync;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Canal implements ObsGenAsync, GenAsync {
	
	private long time = 0;
	
	private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
	
	private final IGenerateur generateur;
	
	public Canal(IGenerateur generateur) {
		this.generateur = generateur;
	}
	
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
	
	public ScheduledExecutorService getExecutorService() {
		return executorService;
	}
	
	public IGenerateur getGenerateur() {
		return generateur;
	}
}
