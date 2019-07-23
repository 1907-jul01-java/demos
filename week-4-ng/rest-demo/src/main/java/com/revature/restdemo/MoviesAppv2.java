package com.revature.restdemo;

import org.glassfish.jersey.server.ResourceConfig;

public class MoviesAppv2 extends ResourceConfig {
	public MoviesAppv2() {
		packages("com.revature.restdemo");
	}
}
