package com.istic.ila.aoc.factory.impl;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.impl.AtomicDiffusion;
import com.istic.ila.aoc.diffusion.impl.CausalDiffusion;
import com.istic.ila.aoc.diffusion.impl.SequentialDiffusion;
import com.istic.ila.aoc.factory.DiffusionFactory;
import com.istic.ila.aoc.factory.exception.NotSupportedException;

public class DiffusionFactoryImpl implements DiffusionFactory {
    @Override
    public Diffusion factoryMethod(DiffusionType type) throws NotSupportedException {
        Diffusion diffusion = null;

        switch (type) {
            case ATOMIC_DIFFUSION:
                diffusion = new AtomicDiffusion();
                break;

            case CAUSAL_DIFFUSION:
                diffusion = new CausalDiffusion();
                break;

            case SEQUENTIAL_DIFFUSION:
                diffusion = new SequentialDiffusion();
                break;

            default:
                throw new NotSupportedException(type.name());
        }

        return diffusion;
    }
}
