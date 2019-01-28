package com.istic.ila.aoc.activeobject.mi;

import com.istic.ila.aoc.activeobject.mi.impl.UpdateImpl;
import com.istic.ila.aoc.activeobject.proxy.Canal;
import com.istic.ila.aoc.activeobject.service.ObserverGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateTest {
    private Update update;

    @Mock
    private Canal canal;

    @Mock
    private ObserverGenerator observerGenerator;

    @Before
    public void setUp() {
        this.update = new UpdateImpl(this.observerGenerator, this.canal);
    }

    @Test
    public void call_ShouldUpdateObserver() throws Exception {
        this.update.call();

        verify(this.observerGenerator).update(this.canal);
    }
}
