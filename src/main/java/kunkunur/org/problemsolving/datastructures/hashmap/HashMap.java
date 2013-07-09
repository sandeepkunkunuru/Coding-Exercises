package kunkunur.org.problemsolving.datastructures.hashmap;

import java.util.ArrayList;

public class HashMap {
	private ArrayList<HashTableEntry> htEntryList = new ArrayList<HashTableEntry>();

	public void put(Object key, Object value) {

		Entry entry = new Entry();

		entry.setKey(key);
		entry.setValue(value);

		int hashCode = generateHashCode(key);


		boolean htEntryExists = false;
		
		for (int i = 0; i < htEntryList.size(); i++) {
			HashTableEntry htEntry = htEntryList.get(i);

			if (hashCode == htEntry.getHashcode()) {
				htEntryExists = true;
				
				ArrayList<Entry> entryList = htEntry.getEntryList();
				boolean entryExists = false;

				for (int j = 0; j < entryList.size(); j++) {
					if (entryList.get(j).getKey().equals(key)) {
						entryExists = true;
						entryList.get(j).setValue(value);
						break;
					}
				}

				if (!entryExists) {
					entryList.add(entry);
				}
				
				break;
			}

		}
		
		if (!htEntryExists) {
			HashTableEntry htEntry = new HashTableEntry();
			htEntry.setHashcode(hashCode);
			
			ArrayList<Entry> entryList = new ArrayList<Entry>();
			entryList.add(entry);
			
			htEntry.setEntryList(entryList);
			
			htEntryList.add(htEntry);
		}

	}

	public Object get(Object key) {
		int hashCode = generateHashCode(key);

		HashTableEntry htEntry = new HashTableEntry();

		for (int i = 0; i < htEntryList.size(); i++) {
			htEntry = htEntryList.get(i);

			if (hashCode == htEntry.getHashcode()) {
				ArrayList<Entry> entryList = htEntry.getEntryList();

				for (int j = 0; j < entryList.size(); j++) {
					if (entryList.get(j).getKey().equals(key)) {
						return entryList.get(j).getValue();
					}
				}

			}

		}

		return null;

	}

	private int generateHashCode(Object key) {

		String str = key.toString();

		return 2 * str.charAt(0) ^ 1 + 2 * str.charAt(1) ^ 2;
	}
}
