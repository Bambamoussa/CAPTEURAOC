package com.istic.ila.aoc.proxy;

import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.servant.Observer;
import com.istic.ila.aoc.servant.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Canal implements Observer, Subject {

    private static Logger LOGGER = Logger.getLogger(Canal.class.getName());

	private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);
	
	private final IGenerateur generateur;
	
	private List<Observer<IGenerateur>> observers = new ArrayList<>();
	
	public Canal(IGenerateur generateur) {
		this.generateur = generateur;
	}
	
	public ScheduledExecutorService getExecutorService() {
		return executorService;
	}
	
	public IGenerateur getGenerateur() {
		return generateur;
	}

    @Override
    public Future update(Object g) {
        if (g instanceof IGenerateur) {
            IGenerateur generateur = (IGenerateur) g;
            int time = new Random().nextInt(10000) + 1000;
            LOGGER.info("Canal service delay : " + time + "ms.");
            return executorService.schedule(() -> {
                observers.forEach(o -> o.update(generateur));
                return null;
            }, time, TimeUnit.MILLISECONDS);
        }
        return null;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
}
