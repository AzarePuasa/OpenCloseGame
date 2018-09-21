package com.azare.thoughtworks.openclose.consoleinput;

import java.util.Scanner;

/*
 * Handles Console input for the application
 */
public class ConsoleStringInput implements IConsoleInput {
	
	private String input;
	private int length;
	
	public void readConsole() {
		try (Scanner sc = new Scanner(System.in)) {
			input = sc.nextLine();
		}
		length = input.length();
	}
	
	public String getInput()
	{
		return this.input;
	}
	
	public int getInputLength()
	{
		return this.length;
	}
}
