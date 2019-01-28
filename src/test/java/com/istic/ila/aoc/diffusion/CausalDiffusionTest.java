package com.istic.ila.aoc.diffusion;

import com.istic.ila.aoc.diffusion.exception.BadConfigurationException;
import com.istic.ila.aoc.diffusion.impl.CausalDiffusion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CausalDiffusionTest {
    private CausalDiffusion diffusion;

    @Before
    public void setUp() {
        this.diffusion = new CausalDiffusion();
    }

    @Test
    public void execute_ReturnSeatedValue() throws BadConfigurationException {
        this.diffusion.setValue(10);
        assertEquals(new Integer(10), this.diffusion.execute());
    }
}
