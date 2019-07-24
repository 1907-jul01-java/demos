package com.revature.restdemo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/v2")
public class MoviesAppv2 extends ResourceConfig {
	public MoviesAppv2() {
		packages("com.revature.restdemo");
	}
}
