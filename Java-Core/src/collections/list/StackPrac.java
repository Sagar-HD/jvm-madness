package collections.list;

import java.util.Stack;

class StackPrac{
	
	
	public static void main(String... args){
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		
		/*
		push(E item)
pop()
peek()
empty()
search(Object o)
		
		*/
		stack.pop();
		System.out.println(stack.empty());
		System.out.println(stack.search(1));
	}
	
	
	
	
}