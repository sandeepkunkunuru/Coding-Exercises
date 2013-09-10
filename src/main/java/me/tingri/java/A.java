package me.tingri.java;

public class A {
	public static void main(String args[]) {
		int age = 2;
		assert (age < 0 ): "1232";
		/* if age is valid (i.e., age>0) */
		if (age >= 18) {
			System.out.println("You're an adult!");
		}
	}
}