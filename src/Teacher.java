public class Teacher {
	private String name;

	public Teacher() {
	}

	public Teacher(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Teacher{name = " + name + "}";
	}
}
