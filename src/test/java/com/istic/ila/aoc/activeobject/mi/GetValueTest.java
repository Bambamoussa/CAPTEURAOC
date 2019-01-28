package com.istic.ila.aoc.activeobject.mi;

import com.istic.ila.aoc.activeobject.mi.impl.GetValueImpl;
import com.istic.ila.aoc.activeobject.proxy.Canal;
import com.istic.ila.aoc.activeobject.service.Generator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetValueTest {
    private GetValue getValue;

    @Mock
    private Generator<Integer> generator;

    @Mock
    private Canal canal;

    @Before
    public void setUp() {
        this.getValue = new GetValueImpl<Integer>(this.generator, this.canal);
    }

    @Test
    public void call_ShouldGetValueFromGenerator() throws Exception {
        this.getValue.call();

        verify(this.generator).getValue(this.canal);
    }
}
