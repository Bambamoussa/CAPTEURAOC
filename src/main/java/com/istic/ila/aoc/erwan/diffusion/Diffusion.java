package com.istic.m2.aoc.diffusion;

import com.istic.m2.aoc.activeobject.service.GeneratorAsync;
import com.istic.m2.aoc.strategy.Strategy;

/**
 * Diffusion strategy
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Diffusion extends Strategy {

    /**
     * Execute algorithm
     */
    void execute();

    /**
     * Return generated value
     * @param generator Values generator
     * @return generated value by the generator
     */
    Integer getValue(GeneratorAsync generator);
}
