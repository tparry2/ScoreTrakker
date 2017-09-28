import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void loadDataFromFile(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
		
			String line = br.readLine();
			while(line != null) {
				Student temp = new Student(line, Integer.parseInt(br.readLine()));
				studentList.add(temp);
				line=br.readLine();
			}
			
			br.close();
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printInOrder() {
		Collections.sort(studentList);
		for(Student s : studentList) {
			System.out.println(s.toString());
		}
	}
	
	public void processFiles(String file) {
		loadDataFromFile(file);
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles("scores.txt");
	}

}
