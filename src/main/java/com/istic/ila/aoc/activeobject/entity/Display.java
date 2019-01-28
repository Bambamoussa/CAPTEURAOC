package com.istic.ila.aoc.activeobject.entity;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.activeobject.service.ObserverGenerator;
import com.istic.ila.aoc.observer.Observable;
import com.istic.ila.aoc.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Implementation of ObserverGenerator interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class Display implements ObserverGenerator, Observable {
    private String name;
    private List<Observer> observers = new ArrayList<>();
    private String message;
    private Integer value;

    /**
     * Constructor
     * @param name Display name
     */
    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(Generator observable) {
        Future<Integer> value = (Future<Integer>) observable.getValue();

        try {
            this.value = value.get();
            this.message = this.name + ": " + this.value;
            System.out.println(this.message);
            this.notifyObservers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter
     * @return message with generated value
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Getter
     * @return display name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter
     * @return generated value
     */
    public String getValue() {
        return this.value.toString();
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }
}
