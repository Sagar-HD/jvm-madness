package collections.list;
import java.util.List;
import java.util.LinkedList;
class LinkedListPrac{
	public static void main(String... args){
		
		List<Integer> list=new LinkedList<Integer>();
		// all list methods add,get,remove,size ,clear,contains,set
		//addFirst,addLast,getFirst,getLast,removeFirst,removeLast
		//peek,pop,push
		//offer,poll
		list.add(1);
		list.add(1);
		list.add(1);
		//we must use linkedlist ref to use its methods
		LinkedList<Integer> linkedlist=new LinkedList<Integer>();
		linkedlist.add(1);
		linkedlist.add(1);
		linkedlist.add(1);
		//addFirst
		linkedlist.addFirst(0);
		//addLast
		linkedlist.addLast(2);
		System.out.println(linkedlist);
		//getFirst
			System.out.println(linkedlist.getFirst());
		//getLast
		System.out.println(linkedlist.getLast());
		//removeFirst and removeLast
		
		//peek
		System.out.println(linkedlist.peek());
		
	   // offer adds like queue means in back 
	   //{0,1,1,1,2,2} got added at end
	   linkedlist.offer(2);
	   // push
	   //{0,0,1,1,1,2,2} got added at end
	    linkedlist.push(0);
		System.out.println(linkedlist);
		// pool returns and removes top elem
	   System.out.println(linkedlist.poll());
	   //peek and pop
	}
}