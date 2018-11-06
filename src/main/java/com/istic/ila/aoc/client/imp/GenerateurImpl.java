package com.istic.ila.aoc.client.imp;

import com.istic.ila.aoc.client.Generateur;
import com.istic.ila.aoc.methodInvocation.concreteMethodInvocation.GetValue;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

public class GenerateurImpl implements Generateur {
	
	private int value;
	
	List<Observer> observers = new LinkedList<>();
	
	public GenerateurImpl() {
		value = 0;
	}
	
	public static void main(String[] args) {
		
		GenerateurImpl generateur = new GenerateurImpl();
		GetValue getValue = new GetValue();
		
		while (true) {
			generateur.setValue(generateur.getValue() + 1);
		}
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
