package com.istic.ila.aoc.strategy;

import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;

/**
 * Strategy interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Strategy<T> {
    /**
     * Algorithm execution
     */
    T execute() throws BadConfigurationException;
}
