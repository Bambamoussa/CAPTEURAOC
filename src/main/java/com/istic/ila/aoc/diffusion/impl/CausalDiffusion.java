package com.istic.ila.aoc.diffusion.impl;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.observer.Observer;

public class CausalDiffusion<T> implements Diffusion<T> {
    private T value;

    public T execute() throws BadConfigurationException {
        if(value == null) {
            throw new BadConfigurationException("value");
        }

        return this.value;
    }

    @Override
    public void configure(Observer observer) {

    }

    @Override
    public void configure(Generator generator) {

    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
