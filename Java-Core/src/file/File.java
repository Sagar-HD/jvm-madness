import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
class File{
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
	
	try(File file=new File("sample.txt")){
		file.createNewFile();
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
}
	
	
}