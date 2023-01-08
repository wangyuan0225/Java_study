package others;

public class GirlFriend {
	private int age;

	public GirlFriend() {
	}

	public GirlFriend(int age) {
		this.age = age;
	}

	//set
	public void setAge(int age) {
		if (age >= 18 && age <= 50) {
			this.age = age;
		} else {
			System.out.println("非法数据");
		}
	}
	//get
	public int getAge() {
		return age;
	}
}
