package com.istic.ila.aoc.servant;

import java.util.concurrent.Future;

public interface Observer<T> {

    Future<T> update(T g);

}
