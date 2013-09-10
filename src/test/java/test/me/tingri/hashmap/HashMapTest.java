package test.me.tingri.hashmap;

import me.tingri.problemsolving.datastructures.hashmap.HashMap;

import org.junit.Test;

public class HashMapTest {
	String testKey = "Sandeep";
	String testValue = "SandeepValue";
	String testKey2 = "Narayana";
	String testValue2 = "NarayanaValue2";
	HashMap map = new HashMap();

	@Test
	public void testPut() {
	}

	@Test
	public void testGet() {
		map.put(testKey, testValue);
		map.put(testKey2, testValue2);
		map.put("Saritha", "Gowri");

		System.out.println(map.get(testKey));
		System.out.println(map.get(testKey2));
		System.out.println(map.get("Saritha"));
	}

}
