package com.istic.ila.aoc.observer;

/**
 * Observable interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Observable {
    /**
     * Add an observer
     * @param observer observer to add
     */
    void attach(Observer observer);

    /**
     * Remove an observer
     * @param observer observer to remove
     */
    void detach(Observer observer);

    /**
     * Notify all observers that state have updated
     */
    void notifyObservers();
}
