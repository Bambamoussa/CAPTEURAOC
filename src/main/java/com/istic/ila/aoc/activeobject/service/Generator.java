package com.istic.ila.aoc.activeobject.service;

import com.istic.ila.aoc.observer.Observable;
import com.istic.ila.aoc.observer.Observer;

/**
 * Generator interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Generator<T> extends Observable {
    /**
     * Return generated value
     * @return generated value
     */
    T getValue(Observer observer);

    /**
     * Return generated value
     * @return generated value
     */
    T getValue();

    /**
     * Start to generate value
     */
    void generate();

    /**
     * Call generate method every n seconds
     */
    void tick();

    /**
     * Toggle stop value (true -> false, false -> true with toggle)
     * @return value of stop after toggle
     */
    boolean toggleStop();

    /**
     * Stop generator
     */
    void stop();

    /**
     * Return number of observers
     * @return number of observers
     */
    int numberOfObservers();
}
