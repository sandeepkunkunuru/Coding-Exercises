package me.tingri.problemsolving.datastructures;

import java.util.HashSet;

/**
 * 	//Nodes
	
	//Vertices
	//Example 2 --> 3 --> 5 and 2 --> 4  and 3 --> 6 then
	// 5 --> 2 and 6-->2 are not valid but
	// 3 --> 4 and 5 --> 4 and 2 --> 6  and 5 --> 6are valid
	
	//add node doesnt violate DAG
	//add edge may violate DAG
	//For simplicity lets start with a case such that node isnt added unless there is an edge
	// add(T value, T[] edges) with known nodes.
	 
 * @author kunkunur
 *
 * @param <T>
 */
public class DirectedAcyclicGraph<T> {
	HashSet<Node<T>> nodes = new HashSet<Node<T>>();
	HashSet<Edge<Node<T>, Node<T>>> edges = new HashSet<Edge<Node<T>, Node<T>>>();
	
	
	public DirectedAcyclicGraph(T value){
		  new Node<T>(value);
	}
	
	public DirectedAcyclicGraph<T> addNode(T value){
		this.nodes.add(new Node<T>(value));
		return this;
	}

	
	public DirectedAcyclicGraph<T> addEdge(T value1, T value2){
		//nodes.
		
		//this.edges.add(new Edge<T>(value));
		return this;
	}

	
	private class Node<T>{
		T value;
		
		public Node(T value){
			this.value = value;
		}
	}
	
	private class Edge<S extends Node<T>, R extends Node<T>>{
		Node<T> start;
		Node<T> end;
		
		public Edge(Node<T> start, Node<T> end){
			this.start = start;
			this.end = end;
		}
	}
	

}
