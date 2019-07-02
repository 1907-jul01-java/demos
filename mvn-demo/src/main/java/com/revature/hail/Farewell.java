package com.revature.hail;

/**
 * Farewell
 */
public class Farewell extends Hail {
    public Farewell(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        return "Farewell, " + name + "!";
    }

}