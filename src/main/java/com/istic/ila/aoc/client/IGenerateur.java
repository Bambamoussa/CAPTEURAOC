package com.istic.ila.aoc.client;

import com.istic.ila.aoc.servant.Subject;

public interface IGenerateur extends Subject {
	
	void setValue(int value);
	
	int getValue();
	
}
