import java.lang.*;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Student s) {
		return this.score - s.score;
	}

	@Override
	public String toString() {
		return name + " " + score ;
	}
	
	

}
