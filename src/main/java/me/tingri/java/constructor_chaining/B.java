package me.tingri.java.constructor_chaining;

public class B extends A {
	

	public B(){
		System.out.println("SUB_CONSTRUCTOR");
	}
	
	public B(String abc){
		System.out.println("SUB_CONSTRUCTOR_WITH_PARAMS");
	}
	
	public B(int abc){
		super(abc);
		System.out.println("SUB_CONSTRUCTOR_WITH_PARAMS");
	}
	
	public static void main(String[] s){
		B b = new B();
		B b1 = new B("PARAM");
		B b2 = new B(123);

	}

}
