package com.istic.ila.aoc.client;

import com.istic.ila.aoc.proxy.Canal;
import com.istic.ila.aoc.servant.Observer;

import java.util.ArrayList;
import java.util.List;

public class Generateur implements IGenerateur {
	
	private int value;

    private List<Observer<Canal>> observers = new ArrayList<>();

	public void setValue(int value) {
		this.value = value;
		//strategy.execute(this);
	}
	
	public int getValue() {
		return value;
	}

	public Generateur(){}

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
}
