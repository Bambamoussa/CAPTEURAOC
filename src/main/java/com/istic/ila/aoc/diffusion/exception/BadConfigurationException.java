package com.istic.ila.aoc.diffusion.exception;

public class BadConfigurationException extends Exception {
    public BadConfigurationException(String configName) {
        super("You must specify a " + configName);
    }
}
