package com.istic.ila.aoc.service;

import com.istic.ila.aoc.client.IGenerateur;

import java.util.concurrent.Future;

public interface ObsGenAsync {
	
	Future update(final IGenerateur generateur);
}
