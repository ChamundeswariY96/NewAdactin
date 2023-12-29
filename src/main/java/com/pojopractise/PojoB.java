package com.pojopractise;

public class PojoB {
	public static void main(String[] args) {
		Pojo_PractiseA a = new Pojo_PractiseA();
		String name = a.getName();
		System.out.println("Before setters name is "  +name);
		a.setName("James");
		String name2 = a.getName();
		System.out.println("After setters name is  "   +name2);
		
	}

}
