package com.istic.ila.aoc.activeobject.entity;

import com.istic.ila.aoc.DiffusionType;
import com.istic.ila.aoc.activeobject.service.Generator;
import com.istic.ila.aoc.diffusion.Diffusion;
import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.factory.DiffusionFactory;
import com.istic.ila.aoc.factory.exception.NotSupportedException;
import com.istic.ila.aoc.observer.Observer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class IntegerGeneratorTest {
    private Generator<Integer> generator;

    @Mock
    private Diffusion diffusion;

    @Mock
    private DiffusionFactory factory;

    @Mock
    private Observer observer;

    @Mock
    private Observer observer2;

    @Before
    public void setUp() throws NotSupportedException {
        this.generator = new IntegerGenerator(DiffusionType.ATOMIC_DIFFUSION);
        this.generator.attach(this.observer);
    }

    @Test
    public void generate_IncrementValue() throws NoSuchFieldException, IllegalAccessException {
        Field value = this.generator.getClass().getDeclaredField("value");
        value.setAccessible(true);

        this.generator.generate();
        assertEquals(new Integer(0), value.get(this.generator));
        this.generator.generate();
        assertEquals(new Integer(1), value.get(this.generator));
    }

    @Test
    public void generate_ShouldNotifyObservers() {
        this.generator.generate();

        verify(this.observer).update(this.generator);
    }

    @Test
    public void getValue_ShouldExecuteDiffusion() throws BadConfigurationException {
        this.generator.getValue();

        verify(this.diffusion).execute();
    }

    @Test
    public void attach_AddNewObserver() {
        this.generator.attach(this.observer2);
        this.generator.notifyObservers();

        verify(this.observer2).update(this.generator);
    }

    @Test
    public void detach_RemoveObserver() {
        this.generator.detach(this.observer);

        verify(this.observer, never()).update(this.generator);
    }
}
