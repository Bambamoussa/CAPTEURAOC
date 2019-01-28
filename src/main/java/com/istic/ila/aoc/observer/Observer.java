package com.istic.ila.aoc.observer;

/**
 * Observer interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Observer<T> {
    /**
     * Notify observer that can pull the updated state from the observable
     * @param observable Updated observable
     */
    void update(T observable);
}
