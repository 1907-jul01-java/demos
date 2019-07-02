package com.revature.hail;

public abstract class Hail implements Callable {
    protected String name;

    public Hail() {
        super();
    }

    public Hail(String name) {
        this.name = name;
    }
}