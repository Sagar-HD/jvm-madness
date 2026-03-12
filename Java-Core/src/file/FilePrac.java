import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class FilePrac{
public static void main(String... args){
	try{
	FileWriter writer=new FileWriter("test.txt");
	writer.write("hii testing file io");
	writer.close();
	System.out.println("file writing success");

	
	
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	File file=new File("sample.txt");
	try{
		file.createNewFile();
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	try(FileWriter sampleWriter=new FileWriter("sample.txt")){
		sampleWriter.write("sample data...");
			System.out.println("file writing success to sample");
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	File textFile=new File("test.txt");
	try{
		Scanner sc= new Scanner(textFile);
		while(sc.hasNextLine()){
			
			System.out.println(sc.nextLine());
		}
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	File sampleFile=new File("sample.txt");
	try{
		Scanner sc1= new Scanner(sampleFile);
		while(sc1.hasNextLine()){
			
			System.out.println(sc1.nextLine());
		}
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	
}
	
	
}