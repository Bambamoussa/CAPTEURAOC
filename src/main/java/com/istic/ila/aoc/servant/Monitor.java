package com.istic.ila.aoc.servant;

import com.istic.ila.aoc.client.IGenerateur;
import com.istic.ila.aoc.service.ObsGenerator;

public class Monitor implements ObsGenerator {
	
	private int value;
	
	public void update(IGenerateur g) {
		this.value = g.getValue();
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void print() {
		System.out.println("Valeur du monitor: " + value);
	}
}
