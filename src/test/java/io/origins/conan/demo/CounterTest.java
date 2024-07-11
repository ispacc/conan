package io.origins.conan.demo;


import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CounterTest {
    static Integer magicNum;

    public static void main(String[] args) {
        if (magicNum == 42) {
            System.out.println(1);
        }

    }

    @Test
    public void test1() {
        HashMap<String, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
