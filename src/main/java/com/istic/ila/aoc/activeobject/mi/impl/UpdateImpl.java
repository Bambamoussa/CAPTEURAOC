package com.istic.ila.aoc.activeobject.mi.impl;

import com.istic.ila.aoc.activeobject.mi.Update;
import com.istic.ila.aoc.activeobject.proxy.Canal;
import com.istic.ila.aoc.activeobject.service.ObserverGenerator;

/**
 * Update MI mplementation
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class UpdateImpl implements Update {
    private ObserverGenerator observerGenerator;
    private Canal canal;

    /**
     * Constructor
     */
    public UpdateImpl(ObserverGenerator observerGenerator, Canal canal) {
        this.observerGenerator = observerGenerator;
        this.canal = canal;
    }

    /**
     * Notify monitor that a new value have generated
     * @return nothing
     */
    public Void call() {
        this.observerGenerator.update(this.canal);
        return null;
    }
}
