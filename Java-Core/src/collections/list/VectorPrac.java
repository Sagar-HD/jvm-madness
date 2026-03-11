package collections.list;
import java.util.Vector;
import java.util.Iterator;
class VectorPrac{
	
	public static void main(String ... args){
		
		//"It uses dynamic array intenally and it synchronised and thread safe"
		System.out.println("vector");
		Vector<Integer> vector=new Vector<Integer>();
		// all methods same as arraylist
		vector.add(1);
		vector.add(2);
		vector.add(3);
		System.out.println(vector);
		//iterator in all collections 
		
    Iterator<Integer> it = vector.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	}
	
}