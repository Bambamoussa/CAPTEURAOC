package com.istic.ila.aoc.diffusion.impl;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.observer.Observer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SequentialDiffusion<T> implements Diffusion<T> {
    private Generator generator = null;
    private T value;
    private boolean settable = true;

    private Set<Observer> observers = new HashSet<>();

    public T execute() throws BadConfigurationException {
        if(generator == null) {
            throw new BadConfigurationException("generator");
        }

        T ret = Objects.requireNonNull(this.value);

        if(this.generator.numberOfObservers() == this.observers.size()) {
            this.observers.clear();
            this.settable = true;
        }

        return ret;
    }

    @Override
    public void configure(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void configure(Generator generator) {
        this.generator = generator;

    }

    @Override
    public void setValue(T value) {
        if(this.settable) {
            this.value = value;
            this.settable = false;
        }
    }
}
