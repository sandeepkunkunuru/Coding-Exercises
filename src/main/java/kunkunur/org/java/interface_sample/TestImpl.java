package kunkunur.org.java.interface_sample;


public class TestImpl implements ITestConstantsAndInnerClasses {

	public static void main(String[] s){
		System.out.println(ITestConstantsAndInnerClasses.a);
		System.out.println(TestImpl.a);
		
		System.out.println(new ITestConstantsAndInnerClasses.TestInnerClass().getData());
		System.out.println(new TestInnerClass().getData());

		System.out.println(ITestConstantsAndInnerClasses.TestStaticInnerClass.getData());


		 /**
		  * @UNCOMPILABLE
		  */
		//System.out.println(TestImpl.TestStaticInnerClass);

	}
}
