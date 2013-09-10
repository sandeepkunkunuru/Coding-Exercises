package me.tingri.problemsolving.datastructures.hashmap;

import java.util.ArrayList;

public class HashTableEntry {
	
	private int hashcode;
	
	ArrayList<Entry> entryList;

	public int getHashcode() {
		return hashcode;
	}

	public void setHashcode(int hashcode) {
		this.hashcode = hashcode;
	}

	public ArrayList<Entry> getEntryList() {
		return entryList;
	}

	public void setEntryList(ArrayList<Entry> entryList) {
		this.entryList = entryList;
	}
}
