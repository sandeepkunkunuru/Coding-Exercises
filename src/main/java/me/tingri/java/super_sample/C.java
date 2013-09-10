package me.tingri.java.super_sample;

public class C extends B {

	public static void main(String[] s) {
		C c = new C();
		
		c.printSOPs();
		
		System.out.println(((A)c).a);
	}
	
	public void printSOPs(){
		/**
		 * @UNCOMPILABLE		 
		 */
		//System.out.println(this.a);
		
		/**
		 * @UNCOMPILABLE		 
		 */
		//System.out.println(super.a);
		
		System.out.println(((A)this).a);
	}
}
