package collections.list.arraylist;


import java.util.List;
import java.util.ArrayList;

public class ArrayListPrac{
    
   

   public static void main(String... args){
	   
	   
	   List<Integer> list=new ArrayList<Integer>();
	   //add
	   list.add(1);
	   list.add(2);
	   list.add(3);
	   list.add(4);
	   list.add(5);
	   
	   //add with index
	   list.add(1,4);
	   
	   
	   System.out.println(list);
	   //remove by index
	   list.remove(2);
	   
	    System.out.println(list);
	   //contains check
		System.out.println(list.contains(3));
	   //get
		System.out.println(list.get(1));
		//replace by set
		list.set(1,50);
		System.out.println(list);
		// remove by object
		list.remove(new Integer(4));
			System.out.println(list);
		//size
		System.out.println(list.size());
		//isempty
		System.out.println(list.isEmpty());
		//indexOf
		System.out.println(list.indexOf(4));
		//lastIndexOf
		System.out.println(list.lastIndexOf(4));
		//addAll adds another collection
		List<Integer> listToAdd=new ArrayList<>() ;
		listToAdd.add(6);
		listToAdd.add(7);
		listToAdd.add(8);
		list.addAll(listToAdd);
		System.out.println(list);
		//toArray Object array object type must be passes in argument
			Integer arr[]=list.toArray(new Integer[0]);
		for(Integer i : arr){
			System.out.println(i);
		}
		//clear
		list.clear();
		System.out.println(list);
   }

}
