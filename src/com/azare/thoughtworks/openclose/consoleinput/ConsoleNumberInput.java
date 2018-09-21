package com.azare.thoughtworks.openclose.consoleinput;

import java.util.Scanner;

public class ConsoleNumberInput implements IConsoleInput {

	private int input;
	
	@Override
	public void readConsole() {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			input = Integer.parseInt( sc.nextLine() );			
		}
	}
	
	public int getInput() {
		// TODO Auto-generated method stub
		return input; 
	}



}
