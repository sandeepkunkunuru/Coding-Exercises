package kunkunur.org.java.super_sample;

public class B extends A {
	private String a = "SUB";

	public static void main(String[] s) {
		B b = new B();
		b.printSOPs();
	}
	
	public void printSOPs(){
		System.out.println(super.a);
		System.out.println(((A)this).a);

		System.out.println(this.a);


	}
}
