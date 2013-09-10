package me.tingri.problemsolving;

import me.tingri.problemsolving.datastructures.StackNode;

public class SortStack {

	public static void main(String[] args) {
		StackNode<Integer> stack1 = new StackNode<Integer>(34).push(45).push(56).push(12).push(3);
		
		//Final End state = 3 --> 12 --> 34--> 45 -->56
		
		//Lets build another stack which can be used to rearrange.
		StackNode<Integer> stack2 = new StackNode<Integer>(stack1.pop());
		
		while(true){
			int stack1Top = stack1.pop();
			
			int stack2Peek = stack2.peek();
			
			if(stack1Top > stack2Peek){
				stack2.push(stack1Top);
			} else {
				while(stack2.peek() > stack1Top){
					stack1.push(stack2.pop());
				}
				
				stack2.push(stack1Top);
			}
			
			if(stack1.isEmpty()){
				while(!stack2.isEmpty()){
					stack1.push(stack2.pop());
				}
				break;
			}
		}
		
		while(!stack1.isEmpty()){
			System.out.println(stack1.pop());
		}
		
	}

}
