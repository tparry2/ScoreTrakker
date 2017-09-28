import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public void loadDataFromFile(String file) throws FileNotFoundException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try {
			String line = br.readLine();
			while (line != null) {
				String score = "";
				int scr = 999999;
				try {
					score = br.readLine();
					scr = Integer.parseInt(score);
				} catch (NumberFormatException nfe) {
					System.out.println("Incorrect format for " + line + " not a valid score: " + score + "\n");
					line = br.readLine();
					continue;
				}
				Student temp = new Student(line, scr);
				studentList.add(temp);
				line=br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException ioe) {
			System.out.println("IO EXCEPTION");
		}

	}

	
	public void printInOrder() {
		Collections.sort(studentList);
		for(Student s : studentList) {
			System.out.println(s.toString());
		}
		System.out.println("");
	}
	
	public void processFiles() {
		for (String file : files) {
			try {
				loadDataFromFile(file);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + file);
			}
			studentList.clear();
		}
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}

}
