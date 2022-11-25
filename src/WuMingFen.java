public class WuMingFen {
	String theMa;
	int quantity;
	boolean likeSoup;

	public WuMingFen(String theMa, int quantity, boolean likeSoup) {
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}

	public WuMingFen(String theMa, int quantity) {
		this.theMa = theMa;
		this.quantity = quantity;
	}

	public WuMingFen() {
		this.theMa = "酸辣";
		this.quantity = 2;
		this.likeSoup = true;
	}

	void check() {
		System.out.println("面码：" + this.theMa + "，粉的分量：" + quantity + "两，是否带汤：" + likeSoup);
	}
}
