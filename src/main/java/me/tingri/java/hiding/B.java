package me.tingri.java.hiding;

public class B extends A {
	private String a = "SUB";

	public static String getStaticData(){
		return "SUB_STATIC";		
	}
	
	 /**
	  * @UNCOMPILABLE
	  */
	/*
	 public static String getNonStaticData(){
		return "SUB_NON_STATIC";
	 }
	*/
	
	 public String getNonStaticData(){
			return "SUB_NON_STATIC";
	 }
	 
	public static void main(String[] s){
		B b = new B();

		/**
		 * @HIDING
		 */
		System.out.println(b.a);
		System.out.println(((A)b).a);
		
		/**
		 * @HIDING
		 */
		System.out.println(b.getStaticData());
		System.out.println(((A)b).getStaticData());
		
		/**
		 * @OVERRIDING
		 */
		System.out.println(b.getNonStaticData());
		System.out.println(((A)b).getNonStaticData());
		
		/**
		 * @INHERITED
		 */
		System.out.println(b.getData());

	}
	
	

}
