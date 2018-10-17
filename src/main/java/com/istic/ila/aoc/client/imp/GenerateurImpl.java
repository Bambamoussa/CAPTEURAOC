package com.istic.ila.aoc.client.imp;

import com.istic.ila.aoc.client.Generateur;

public class GenerateurImpl implements Generateur {
	
	private int value;
	
	public GenerateurImpl() {
	
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
