package com.istic.ila.aoc.diffusion;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.observer.Observer;
import com.istic.ila.aoc.strategy.Strategy;

/**
 * Diffusion strategy
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Diffusion<T> extends Strategy {

    /**
     * Execute algorithm
     * @return value to diffuse
     */
    T execute() throws BadConfigurationException;

    /**
     * Configure the diffusion
     * @param observer Observer that need the value
     */
    void configure(Observer observer);

    /**
     * Configure the diffusion
     * @param generator generator
     */
    void configure(Generator generator);

    /**
     * Configure the diffusion
     * @param value generated value
     */
    void setValue(T value);
}
