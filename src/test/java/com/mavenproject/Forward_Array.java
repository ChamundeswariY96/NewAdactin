package com.mavenproject;

import java.util.stream.IntStream;

public class Forward_Array {
	public static void main(String[] args) {
		String s1 = "Chamundeswari";
		String s2="";
		int length = s1.length();
		System.out.println(length);
		char ch;
		for (int i = 0; i < length; i++) {
			ch = s1.charAt(i);   //Extract each character separately line by line
			System.out.println(ch);
			s2 = ch + s2;        // add extract character with empty string
				
		}
		System.out.println(s2);    // print the reverse string 
		
	}
		
	}


