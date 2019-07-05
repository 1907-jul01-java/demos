package demo;

import java.io.IOException;
import java.util.Scanner;

public class ApiService {
	private String value;
	
	public String get() {
		return value;
	}
	
	public String set(String value) {
		this.value = value;
		return this.value;
	}
	
	public String scannerSet(Scanner sc) {
		this.value = sc.nextLine();
		return this.value;
	}
	
	public void error() throws IOException {
		throw new IOException();
	}

	public int add(int i, int j) {
		return i + j;
	}
	
//	public static void main(String[] args) {
//		ApiService api = new ApiService();
//		String expected = api.set("value 2");
//		if (expected.equals("value 1")) {
//			System.out.println("Test Passed");
//		} else
//			System.out.println("Test Failed");
//	}
}
