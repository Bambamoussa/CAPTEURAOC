package com.istic.ila.aoc.factory;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.impl.AtomicDiffusion;
import com.istic.ila.aoc.diffusion.impl.CausalDiffusion;
import com.istic.ila.aoc.diffusion.impl.SequentialDiffusion;
import com.istic.ila.aoc.factory.exception.NotSupportedException;
import com.istic.ila.aoc.factory.impl.DiffusionFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DiffusionFactoryTest {
    private DiffusionFactory factory;

    @Before
    public void setUp() {
        this.factory = new DiffusionFactoryImpl();
    }

    @Test
    public void factoryMethod_CreateAtomicDiffusion() throws NotSupportedException {
        Diffusion diffusion = this.factory.factoryMethod(DiffusionType.ATOMIC_DIFFUSION);
        assertThat(diffusion, instanceOf(AtomicDiffusion.class));
    }

    @Test
    public void factoryMethod_CausalAtomicDiffusion() throws NotSupportedException {
        Diffusion diffusion = this.factory.factoryMethod(DiffusionType.CAUSAL_DIFFUSION);
        assertThat(diffusion, instanceOf(CausalDiffusion.class));
    }

    @Test
    public void factoryMethod_SequentialAtomicDiffusion() throws NotSupportedException {
        Diffusion diffusion = this.factory.factoryMethod(DiffusionType.SEQUENTIAL_DIFFUSION);
        assertThat(diffusion, instanceOf(SequentialDiffusion.class));
    }
}
