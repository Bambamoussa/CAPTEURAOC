package com.istic.ila.aoc.activeobject.mi.impl;

import com.istic.ila.aoc.activeobject.mi.GetValue;
import com.istic.ila.aoc.activeobject.proxy.Canal;
import com.istic.ila.aoc.activeobject.service.Generator;

/**
 * GetValue MI Implementation
 * @param <T> Type of returned value
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class GetValueImpl<T> implements GetValue {

    private final Canal canal;
    private final Generator<T> generator;

    /**
     * Constructor
     * @param generator value generator
     * @param canal canal to send generate value
     */
    public GetValueImpl(Generator<T> generator, Canal canal) {
        this.generator = generator;
        this.canal = canal;
    }

    /**
     * Notify the generator to generate a new value
     * @return generated value
     * @throws Exception
     */
    public T call() {
        return this.generator.getValue(this.canal);
    }
}
