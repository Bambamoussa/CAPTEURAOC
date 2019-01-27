package com.istic.m2.aoc.activeobject.mi.impl;

import com.istic.m2.aoc.activeobject.entity.Generator;
import com.istic.m2.aoc.activeobject.mi.Update;

/**
 * Update MI mplementation
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class UpdateImpl implements Update {
    private Generator generator;

    /**
     * Constructor
     * @param generator
     */
    public UpdateImpl(Generator generator) {
        this.generator = generator;
    }

    /**
     * Notify monitor that a new value have generated
     * @return nothing
     * @throws Exception
     */
    public Object call() throws Exception {
        return null;
    }
}
