package com.istic.ila.aoc.proxy;


import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.servant.Observer;
import com.istic.ila.aoc.service.GenAsync;
import com.istic.ila.aoc.service.ObsGenAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Canal implements ObsGenAsync, GenAsync {
	
	private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);
	
	private final IGenerateur generateur;
	
	private List<Observer<IGenerateur>> observers = new ArrayList<>();
	
	public Canal(IGenerateur generateur) {
		this.generateur = generateur;
	}
	
	public Future update(IGenerateur generateur) {
		int time = new Random().nextInt(10) + 1;
		return executorService.schedule(()-> {
			observers.forEach(o -> o.update(generateur));
			return null;
		}, time, TimeUnit.SECONDS);
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
