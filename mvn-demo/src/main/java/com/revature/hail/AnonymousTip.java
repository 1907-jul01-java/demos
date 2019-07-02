package com.revature.hail;

/**
 * AnonymousTip
 */
public class AnonymousTip implements Callable {

    @Override
    public String call() {
        return "Watch out, they're coming for you!";
    }

}