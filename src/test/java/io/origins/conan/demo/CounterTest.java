package io.origins.conan.demo;

public class CounterTest {
    public static void main(String[] args) {

        SimpleCounter simpleCounter = new SimpleCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                simpleCounter.increment();
            }
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                simpleCounter.increment();
            }
        });
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(simpleCounter.getValue());
    }
}
