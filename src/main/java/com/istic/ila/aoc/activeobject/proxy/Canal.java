package com.istic.ila.aoc.activeobject.proxy;

import com.istic.ila.aoc.activeobject.mi.GetValue;
import com.istic.ila.aoc.activeobject.mi.Update;
import com.istic.ila.aoc.activeobject.mi.impl.GetValueImpl;
import com.istic.ila.aoc.activeobject.mi.impl.UpdateImpl;
import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.activeobject.service.ObserverGenerator;
import com.istic.ila.aoc.observer.Observer;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Canal Proxy Class
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class Canal implements Generator, ObserverGenerator {
    private Generator generator;
    private ObserverGenerator observerGenerator;

    private ScheduledExecutorService updateExecutorService;
    private ScheduledExecutorService getValueExecutorService;

    private Random random;

    public Canal(ObserverGenerator observerGenerator, ScheduledExecutorService updateExecutorService, ScheduledExecutorService getValueExecutorService) {
        this.observerGenerator = observerGenerator;
        this.updateExecutorService = updateExecutorService;
        this.getValueExecutorService = getValueExecutorService;
        this.random = new Random();
    }

    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void update(Generator observable) {
        this.generator = observable;
        Update update = new UpdateImpl(this.observerGenerator, this);
        this.updateExecutorService.schedule(update, random.nextInt(1000), TimeUnit.MILLISECONDS);
    }

    @Override
    public Object getValue(Observer observer) {
        return null;
    }

    @Override
    public Future<Integer> getValue() {
        GetValue getValue = new GetValueImpl<Integer>(this.generator, this);
        return this.getValueExecutorService.schedule(getValue, random.nextInt(11), TimeUnit.SECONDS);
    }

    @Override
    public void generate() {

    }

    @Override
    public void tick() {

    }

    @Override
    public boolean toggleStop() {
        return false;
    }

    @Override
    public void stop() {

    }

    @Override
    public int numberOfObservers() {
        return 0;
    }
}
