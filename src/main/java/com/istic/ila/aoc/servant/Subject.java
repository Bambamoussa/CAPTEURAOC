package com.istic.ila.aoc.servant;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);
}
