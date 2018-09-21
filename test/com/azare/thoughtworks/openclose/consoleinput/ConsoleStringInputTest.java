package com.azare.thoughtworks.openclose.consoleinput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ConsoleStringInputTest {

	@Test
	public void testReadConsoleString() {
	    ConsoleStringInput input= new ConsoleStringInput();

	    String strInput = "CO";
	    InputStream in = new ByteArrayInputStream(strInput.getBytes());
	    System.setIn(in);
	    
	    input.readConsole();

	    assertEquals("CO", input.getInput() );
	}
	
	@Test
	public void testReadConsoleStringLengthIsFive()
	{
	    ConsoleStringInput input= new ConsoleStringInput();

	    String strInput = "ABCDE";
	    InputStream in = new ByteArrayInputStream(strInput.getBytes());
	    System.setIn(in);
	    
	    input.readConsole();
	    
	    int iLength = input.getInputLength();
	    
	    assertEquals(5, iLength );	    
	}
	


}
