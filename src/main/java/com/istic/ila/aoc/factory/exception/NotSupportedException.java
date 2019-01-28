package com.istic.ila.aoc.factory.exception;

/**
 * NotSupported Exception
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class NotSupportedException extends Exception {

    /**
     * Constructor
     * @param className
     */
    public NotSupportedException(String className) {
        super("Factory not supported class: " + className);
    }
}
