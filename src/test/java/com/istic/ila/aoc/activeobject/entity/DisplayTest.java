package com.istic.ila.aoc.activeobject.entity;

import com.istic.ila.aoc.activeobject.proxy.Canal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.Future;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DisplayTest {
    private Display display;

    @Mock
    private Canal canal;

    @Mock
    private Future future;

    @Before
    public void setUp() {
        this.display = new Display("Test");
    }

    @Test
    public void update_ShouldGetValueFromCanal() {
        when(this.canal.getValue()).thenReturn(this.future);

        this.display.update(this.canal);

        verify(this.canal).getValue();
    }
}
