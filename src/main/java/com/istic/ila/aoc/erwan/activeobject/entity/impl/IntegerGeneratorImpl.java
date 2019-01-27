package com.istic.m2.aoc.activeobject.entity.impl;

import com.istic.m2.aoc.activeobject.entity.Generator;
import com.istic.m2.aoc.diffusion.Diffusion;
import com.istic.m2.aoc.observer.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Implementation of Generator interface {@see #com.istic.m2.aoc.activeobject.entity.Generator}
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class IntegerGeneratorImpl implements Generator<Integer> {
    private Collection<Observer> observers = new ArrayList<Observer>();

    private Diffusion diffusion;

    private Integer value;

    /**
     * Constructor
     * @param diffusion diffusion strategy
     */
    public IntegerGeneratorImpl(Diffusion diffusion) {
        this.value = 0;
        this.diffusion = diffusion;
    }

    public Integer getValue() {
        return this.diffusion.getValue();
    }

    public void generate() {
        this.setValue(this.value);
        this.notifyObservers();
        this.value++;
    }

    public void setValue(Integer value) {
        this.value = value;
        this.diffusion.execute();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }
}
