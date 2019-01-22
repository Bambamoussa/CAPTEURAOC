package com.istic.ila.aoc.client;

import java.util.Observable;

public class Generateur extends Observable {
	
	private int value;
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
