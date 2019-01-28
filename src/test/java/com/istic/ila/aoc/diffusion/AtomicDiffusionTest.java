package com.istic.ila.aoc.diffusion;

import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.diffusion.impl.AtomicDiffusion;
import com.istic.ila.aoc.observer.Observer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AtomicDiffusionTest {
    private AtomicDiffusion<Integer> diffusion;

    @Mock
    private Generator generator;

    @Mock
    private Observer observer1;

    @Mock
    private Observer observer2;

    private int value;

    @Before
    public void setUp() {
        this.diffusion = new AtomicDiffusion();
        this.generator.attach(this.observer1);
        this.generator.attach(this.observer2);
        this.diffusion.configure(this.generator);
        this.value = 10;
    }

    @Test
    public void execute_ShouldNotLaunchGenerator() throws BadConfigurationException {
        this.diffusion.setValue(this.value);
        this.diffusion.configure(this.observer1);

        assertEquals(new Integer(this.value), this.diffusion.execute());

        verify(this.generator, never()).tick();
    }

    @Test
    public void execute_ShouldLaunchGenerator() throws BadConfigurationException {
        this.diffusion.setValue(this.value);
        this.diffusion.configure(this.observer1);
        this.diffusion.execute();
        this.diffusion.configure(this.observer2);
        this.diffusion.execute();

        verify(this.generator).tick();
    }

    @Test
    public void setValue_ShouldStopGenerator() {
        this.diffusion.setValue(this.value);
        verify(this.generator).stop();
    }
}
