package kunkunur.org.java.hiding;

public class A {
	protected String a = "SUPER";
	
	public String getData(){
		return a;
	}
	
	public String getNonStaticData(){
		return "SUPER_NON_STATIC";		
	}
	
	public static String getStaticData(){
		return "SUPER_STATIC";		
	}
}
