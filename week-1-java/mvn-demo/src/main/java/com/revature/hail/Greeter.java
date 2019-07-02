package com.revature.hail;

public class Greeter extends Hail {
    public Greeter(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        return "Greetings, " + name + "!";
    }

}