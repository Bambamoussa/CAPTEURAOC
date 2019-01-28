package com.istic.ila.aoc.activeobject.entity;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.activeobject.service.ObserverGenerator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Implementation of ObserverGenerator interface
 * @author Erwan IQUEL - Adrien LEBLANC
 * @version 1.0
 */
public class Display implements ObserverGenerator {
    public void update(Generator observable) {
        Future<Integer> value = (Future<Integer>) observable.getValue();

        try {
            System.out.println(value.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
