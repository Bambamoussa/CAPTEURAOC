package com.istic.ila.aoc.servant;

import com.istic.ila.aoc.client.IGenerateur;

import java.util.Observable;

public class Afficheur {
	
	private int value;
	
	public void update(Observable o, Object arg) {
		if(o instanceof IGenerateur) {
			this.value = ((IGenerateur) o).getValue();
		}
	}
}
