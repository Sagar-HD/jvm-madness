package collections.map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.LinkedHashMap;
class HashMapPrac{
	
	public static void main(String... args){
		
		HashMap<Integer,String> hm=new HashMap<>();
		hm.put(1,"Sagar");
		hm.put(2,"Sagar1");
		hm.put(3,"Sagar2");
		hm.put(4,"Sagar3");
		System.out.println(hm.get(1));
		// contains key
		System.out.println(hm.containsKey(2));
		//contains value
		hm.containsValue("Sagar");
		hm.remove(3);
		hm.remove(4);
		System.out.println(hm);
		//iterarting over key set
		Set<Integer> hs= hm.keySet();
	
		for(Integer i: hs){
			
			System.out.println(i);
		}
		//iterating over entryset in hashmap
		for(Map.Entry entry : hm.entrySet()){
			System.out.println("key :"+entry.getKey());
			System.out.println("key :"+entry.getValue());
			
		}
		
		//hashcode and equals overiding for making hashmap not  to store diffrent object with same value or to store same string value in duplicate
		//// implement it 
		
		/*
		           Quick Summary
                   Method	Purpose
                   put()	Insert data
				   get()	Retrieve value
				   remove()	Delete entry
				   containsKey()	Check key
				   containsValue()	Check value
				   size()	Number of elements
					isEmpty()	Check empty
					clear()	Remove all
					keySet()	Get keys
					values()	Get values
					entrySet()	Get key-value pairs
		
		*/
		LinkedHashMap lhm=new LinkedHashMap();
		// same methods implement using dubly linked list
	}
	
	
}