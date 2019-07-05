package demo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ApiServiceTest {
	ApiService api;
	
	@Before
	public void setup() {
		api = new ApiService();
	}
	
	@Test
	public void givenValueThenSetReturnsValue() {		
		String expectedValue = "testValue";
		String actualValue = api.set("testValue");
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void givenScannerThenScannerSetReturnsScannerLine() {
		Scanner sc = new Scanner("value");
		String expected = "value";
		String actual = api.scannerSet(sc);
		assertEquals(expected, actual);
	}
	
	@Test (expected = IOException.class)
	public void whenErrorIsCalledThenThrowIOException() throws IOException {
		api.error();
	}
	
	@Test
	public void whenAis5Bis6ThenAddReturns11() {
		assertEquals(api.add(5, 6), 11);
	}
	
	@Test
	public void whenAis2Bis2ThenAddReturns4() {
		assertEquals(api.add(2,  2), 4);
	}

}
