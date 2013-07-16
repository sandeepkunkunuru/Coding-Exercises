package kunkunur.org.projects.marsrovers.common.util;

public class Logger {
	private Logger(){
		throw new AssertionError("Logger class cannot be instantiated");
	}
	
	public static void log(String message){
		System.out.println("\n" + message + "\n");
	}
}
