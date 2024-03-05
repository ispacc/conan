package io.origins.conan.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter implements Counter {

    private final AtomicInteger value = new AtomicInteger(0);

    @Override
    public void increment() {
        value.getAndIncrement();
    }

    @Override
    public int getValue() {
        return value.get();
    }
}
