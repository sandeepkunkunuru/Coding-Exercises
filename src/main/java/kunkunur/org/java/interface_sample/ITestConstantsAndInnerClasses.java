package kunkunur.org.java.interface_sample;

public interface ITestConstantsAndInnerClasses {
 String a = "aSFDSFS"; 
 
 public static class TestStaticInnerClass{
	 public static String getData(){
		 return a;
	 }
 }
 
 public class TestInnerClass{
	 public static String getData(){
		 return a;
	 }
 }
}
