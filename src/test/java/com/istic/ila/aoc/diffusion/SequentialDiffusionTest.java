package com.istic.ila.aoc.diffusion;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.activeobject.entity.IntegerGenerator;
import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.diffusion.impl.SequentialDiffusion;
import com.istic.ila.aoc.observer.Observer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SequentialDiffusionTest {
    private SequentialDiffusion diffusion;

    private Generator generator;

    @Mock
    private Observer observer1;

    @Mock
    private Observer observer2;

    @Before
    public void setUp() {
        this.diffusion = new SequentialDiffusion();
        this.generator = new IntegerGenerator(DiffusionType.SEQUENTIAL_DIFFUSION);
        this.diffusion.configure(this.generator);
    }

    @Test
    public void setValue_CannotDoConsecutivelyWithMoreThanOneObserver() throws BadConfigurationException {
        this.generator.attach(this.observer1);
        this.generator.attach(this.observer2);
        this.diffusion.setValue(10);

        this.diffusion.configure(this.observer1);
        assertEquals(new Integer(10), this.diffusion.execute());

        this.diffusion.setValue(20);

        this.diffusion.configure(this.observer2);
        assertEquals(new Integer(10), this.diffusion.execute());
    }

    @Test
    public void setValue_ChangeValueWhenAllObserverGotValue() throws BadConfigurationException {
        this.generator.attach(this.observer1);
        this.generator.attach(this.observer2);

        this.diffusion.setValue(10);
        this.diffusion.configure(this.observer1);
        assertEquals(new Integer(10), this.diffusion.execute());

        this.diffusion.setValue(20);
        this.diffusion.configure(this.observer2);
        this.diffusion.execute();


        this.diffusion.setValue(20);
        this.diffusion.configure(this.observer1);
        assertEquals(new Integer(20), this.diffusion.execute());
    }

    @Test
    public void execute_ReturnSeatedValue() throws BadConfigurationException {
        this.diffusion.setValue(10);

        assertEquals(new Integer(10), this.diffusion.execute());
    }
}
