package com.revature;

import com.revature.hail.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            Hail greeter = new Greeter(args[0]);
            Hail farewell = new Farewell(args[0]);

            SalutationService salutationService = new SalutationService(greeter, farewell);

            System.out.println(salutationService.hello());
            System.out.println(salutationService.goodbye());
        } else
            System.out.println("Usage: java com.revature.App name");
    }
}
