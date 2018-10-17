package com.istic.ila.aoc.strategy;

import com.istic.ila.aoc.client.Generateur;

public interface Strategy {
	
	void update();
	
	void execute(Generateur g);
}
