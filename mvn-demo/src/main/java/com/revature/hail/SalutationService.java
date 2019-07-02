package com.revature.hail;

/**
 * SalutationService
 */
public class SalutationService {
    Hail hello;
    Hail goodbye;

    public SalutationService(Hail hello, Hail goodbye) {
        this.hello = hello;
        this.goodbye = goodbye;
    }

    public String hello() {
        return hello.toString();
    }

    public String goodbye() {
        return goodbye.toString();
    }
}