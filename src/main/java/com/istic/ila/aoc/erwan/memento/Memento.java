package com.istic.m2.aoc.memento;

/**
 * Memento interface
 * @param <T> type of state to save
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public interface Memento<T> {
    /**
     * Return saved state
     * @return saved state
     */
    T getState();
}
