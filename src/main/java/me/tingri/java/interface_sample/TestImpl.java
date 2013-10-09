package me.tingri.java.interface_sample;


public class TestImpl implements ITestConstantsAndInnerClasses {

	public static void main(String[] s){
		System.out.println(ITestConstantsAndInnerClasses.a);
		System.out.println(ITestConstantsAndInnerClasses.a);
		
		new ITestConstantsAndInnerClasses.TestInnerClass();
		System.out.println(TestInnerClass.getData());
		new TestInnerClass();
		System.out.println(TestInnerClass.getData());

		System.out.println(ITestConstantsAndInnerClasses.TestStaticInnerClass.getData());


		 /**
		  * @UNCOMPILABLE
		  */
		//System.out.println(TestImpl.TestStaticInnerClass);

	}
}
