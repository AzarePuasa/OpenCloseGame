package com.azare.thoughtworks.openclose.consoleinput;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class ConsoleNumberInputTest {
	@Test
	public void testReadConsoleNumber() {
	    ConsoleNumberInput input= new ConsoleNumberInput();

	    String strInput = "5";
	    InputStream in = new ByteArrayInputStream(strInput.getBytes());
	    System.setIn(in);
	    
	    input.readConsole();
	    
	    assertEquals(5, input.getInput());
	}
}
