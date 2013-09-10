package me.tingri.java.enums;

public enum Days {
	SUNDAY("sunday"), 
	MONDAY("1"), //just trying to put some value
	TUESDAY("tuesday"), 
	WEDNESDAY("wednesday"), 
	THURSDAYDAY("thursday"), 
	FRIDAY("friday"), 
	SATURDAY("saturday");

	String value;

	Days(String name) {
		this.value = name;
	}

	//static methods are allowed
	public static Days someMethod() {
		//valueOf method returns an enum whose name is the string provided
		//hence below statement returns Days.MONDAY
		return Days.valueOf("MONDAY");
	}

	//main method is allowed
	public static void main(String[] s) {
		//values() returns an array of enum type
		for (Days day : Days.values()) {
			System.out.println(day.value);
		}
		//.value refers to the member variable value "sunday"
		System.out.println(someMethod().value); 
		// name method refers to name of the enum - MONDAY
		System.out.println(someMethod().name()); 
	}
}
