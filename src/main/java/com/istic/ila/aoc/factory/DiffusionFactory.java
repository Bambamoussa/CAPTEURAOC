package com.istic.ila.aoc.factory;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.factory.exception.NotSupportedException;

public interface DiffusionFactory {
    Diffusion factoryMethod(DiffusionType type) throws NotSupportedException;
}
