package com.istic.m2.aoc.observer;

/**
 * Observer interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Observer {
    /**
     * Notify observer that can pull the updated state from the observable
     * @param observable Updated observable
     */
    void update(Observable observable);
}
