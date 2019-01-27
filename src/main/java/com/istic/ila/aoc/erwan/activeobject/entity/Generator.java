package com.istic.m2.aoc.activeobject.entity;

import com.istic.m2.aoc.observer.Observable;

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
    T getValue();

    /**
     * Start to generate value
     */
    void generate();

    /**
     * Set new generated value
     * @param value
     */
    void setValue(T value);
}
