package com.istic.ila.aoc.activeobject.entity;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.factory.DiffusionFactory;
import com.istic.ila.aoc.factory.exception.NotSupportedException;
import com.istic.ila.aoc.factory.impl.DiffusionFactoryImpl;
import com.istic.ila.aoc.observer.Observer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of Generator interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class IntegerGenerator implements Generator<Integer> {
    private Collection<Observer> observers = new ArrayList<Observer>();

    private Diffusion<Integer> diffusion;
    private DiffusionFactory diffusionFactory;
    private DiffusionType diffusionType;

    private Integer value;

    private boolean stop;

    /**
     * Constructor
     * @param diffusionType diffusion type
     */
    public IntegerGenerator(DiffusionType diffusionType) {
        this.value = -1;
        this.diffusionType = diffusionType;
        this.diffusionFactory = new DiffusionFactoryImpl();

        try {
            this.diffusion = diffusionFactory.factoryMethod(diffusionType);
            this.diffusion.configure(this);
        } catch (NotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getValue(Observer observer) {
        Integer value = null;

        try {
            this.diffusion.configure(observer);
            value = this.diffusion.execute();
        } catch (BadConfigurationException e) {
            e.printStackTrace();
        }

        return value;
    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public void tick() {
        this.stop = false;

        while(!stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.generate();
        }
    }

    @Override
    public boolean toggleStop() {
        return this.stop = !this.stop;
    }

    @Override
    public void stop() {
        this.stop = true;
    }

    @Override
    public int numberOfObservers() {
        return this.observers.size();
    }

    @Override
    public void generate() {
        this.value++;
        this.diffusion.setValue(value);
        this.notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
    }
}
