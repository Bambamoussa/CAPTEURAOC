package com.istic.ila.aoc.servant;

import java.util.Observable;
import java.util.Observer;

public interface ObsGenerateur extends Observer {
	
	@Override
	void update(Observable observable, Object o);
}
