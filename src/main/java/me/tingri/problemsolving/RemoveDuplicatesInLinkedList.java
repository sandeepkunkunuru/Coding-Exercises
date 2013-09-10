package me.tingri.problemsolving;

import me.tingri.problemsolving.datastructures.LinkedList;

/*Write code to remove duplicates from an unsorted linked list

 FOLLOW UP

 How would you solve this problem if a temporary buffer is not allowed?

 // Nodes which are linked to each other Node A ---> Node B
 // Node A ‘ value > Node B’ value
 // Find duplicates
 // Compare Node A with all other nodes in linked list and if there is a match then remove the duplicate
 // Remove duplicates
 // Node A → Node B ---> NodeC if you remove Node B then Node A ---> Node C
 //  2---> 5 ---> 3 ---> 2 ---> 3 ---> 5
 */

public class RemoveDuplicatesInLinkedList {

	public static void main(String[] s) {
		LinkedList list = new LinkedList(2).add(5).add(3).add(2).add(3).add(5); // Builder
																				// Pattern.

		list.print();
		list.removeDuplicates();
		list.print();

		list = new LinkedList(2).add(2);

		list.print();
		list.removeDuplicates();
		list.print();

		list = new LinkedList(2);

		list.print();
		list.removeDuplicates();
		list.print();

		list = new LinkedList(2).add(3);

		list.print();
		list.removeDuplicates();
		list.print();

	}

}
