package com.istic.m2.aoc.memento;

/**
 * Caretaker interface
 * @param <T> Type of memento state
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Caretaker<T> {
    /**
     * Add a memento to the caretaker list
     * @param m memento to add
     */
    void add(Memento<T> m);

    /**
     * Return a memento at specified index
     * @param index where to find the memento
     * @return Memento at specified index
     */
    Memento<T> get(int index);
}
