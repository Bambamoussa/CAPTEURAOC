package com.istic.m2.aoc.memento;

/**
 * Origin object & creator of mementos
 * @param <T> Type of state to save
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Originator<T> {
    /**
     * Create a new memento instance
     * @return memento instance
     */
    Memento<T> saveToMemento();

    /**
     * Recover an encapsulated state in specified memento
     * @param memento memento where the state have saved
     */
    void restoreFromMemento(Memento<T> memento);
}
