public class Student extends Person {
	String name = "李四";

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public void sout() {
		System.out.println(name);
	}

}
