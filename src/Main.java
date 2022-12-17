public class Main {
	public static void main(String[] args) {
		Weekday day = Weekday.SUN;
		if (day.dayValue == 6 || day.dayValue == 0) {
			System.out.println("Today is " + day + ". Work at home!");
		} else {
			System.out.println("Today is " + day + ". Work at office!");
		}
	}
}

enum Weekday {
	MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

	public final int dayValue;
	private final String chinese;

	private Weekday(int dayValue, String chinese) {
		this.dayValue = dayValue;
		this.chinese = chinese;
	}

	@Override
	public String toString() {
		return this.chinese;
	}
}


//public class Main {
//	public static void main(String[] args) {
//		String[] names = {"Bob", "Alice", "Grace"};
//		var sb = new StringBuilder();
//		sb.append("Hello ");
//		for (String name : names) {
//			sb.append(name).append(", ");
//		}
//		// 注意去掉最后的", ":
//		sb.delete(sb.length() - 2, sb.length());
//		sb.append("!");
//		System.out.println(sb.toString());
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Adder adder = new Adder();
//		adder.add(3)
//				.add(5)
//				.inc()
//				.add(10);
//		System.out.println(adder.value());
//	}
//}
//
//class Adder {
//	private int sum = 0;
//
//	public Adder add(int n) {
//		sum += n;
//		return this;
//	}
//
//	public Adder inc() {
//		sum++;
//		return this;
//	}
//
//	public int value() {
//		return sum;
//	}
//
//}

//public class Main {
//	public static void main(String args[]) {
//
//		/**
//		 *Math.sqrt()//计算平方根
//		 *Math.cbrt()//计算立方根
//		 *Math.pow(a, b)//计算a的b次方
//		 *Math.max( , );//计算最大值
//		 *Math.min( , );//计算最小值
//		 */
//		System.out.println(Math.sqrt(16));  //4.0
//		System.out.println(Math.cbrt(8));  //2.0
//		System.out.println(Math.pow(3, 2));   //9.0
//		System.out.println(Math.max(2.3, 4.5));//4.5
//		System.out.println(Math.min(2.3, 4.5));//2.3
//
//		/**
//		 * abs求绝对值
//		 */
//		System.out.println(Math.abs(-10.4));  //10.4
//		System.out.println(Math.abs(10.1));   //10.1
//
//		/**
//		 * ceil天花板的意思，就是返回大的值
//		 */
//		System.out.println(Math.ceil(-10.1));  //-10.0
//		System.out.println(Math.ceil(10.7));  //11.0
//		System.out.println(Math.ceil(-0.7));  //-0.0
//		System.out.println(Math.ceil(0.0));   //0.0
//		System.out.println(Math.ceil(-0.0));  //-0.0
//		System.out.println(Math.ceil(-1.7));  //-1.0
//
//		/**
//		 * floor地板的意思，就是返回小的值
//		 */
//		System.out.println(Math.floor(-10.1)); //-11.0
//		System.out.println(Math.floor(10.7));  //10.0
//		System.out.println(Math.floor(-0.7));  //-1.0
//		System.out.println(Math.floor(0.0));  //0.0
//		System.out.println(Math.floor(-0.0));  //-0.0
//
//		/**
//		 * random 取得一个大于或者等于0.0小于不等于1.0的随机数
//		 */
//		System.out.println(Math.random()); //小于1大于0的double类型的数
//		System.out.println(Math.random() * 2);//大于0小于1的double类型的数
//		System.out.println(Math.random() * 2 + 1);//大于1小于2的double类型的数
//
//		/**
//		 * rint 四舍五入，返回double值
//		 * 注意.5的时候会取偶数
//		 */
//		System.out.println(Math.rint(10.1));  //10.0
//		System.out.println(Math.rint(10.7));  //11.0
//		System.out.println(Math.rint(11.5));  //12.0
//		System.out.println(Math.rint(10.5));  //10.0
//		System.out.println(Math.rint(10.51));  //11.0
//		System.out.println(Math.rint(-10.5));  //-10.0
//		System.out.println(Math.rint(-11.5));  //-12.0
//		System.out.println(Math.rint(-10.51)); //-11.0
//		System.out.println(Math.rint(-10.6));  //-11.0
//		System.out.println(Math.rint(-10.2));  //-10.0
//
//		/**
//		 * round 四舍五入，float时返回int值，double时返回long值
//		 */
//		System.out.println(Math.round(10.1));  //10
//		System.out.println(Math.round(10.7));  //11
//		System.out.println(Math.round(10.5));  //11
//		System.out.println(Math.round(10.51)); //11
//		System.out.println(Math.round(-10.5)); //-10
//		System.out.println(Math.round(-10.51)); //-11
//		System.out.println(Math.round(-10.6)); //-11
//		System.out.println(Math.round(-10.2)); //-10
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		String s1 = "hello";
//		String s2 = "Hello";
//
//		//charAt(int index)方法->返回指定索引处的 char值。即找出特定位置的字符，注意索引从0开始
//		System.out.println(s1.charAt(0));//h
//		System.out.println(s1.charAt(4));//o
//		//System.out.println(s1.charAt(5));//越界，编译错误
//
//		//compareTo(String anotherString)方法->按字典顺序比较两个字符串。返回 anotherString - 待比较的 String 。
//		System.out.println(s1.compareTo(s2));//s2 - s1 = 32 > 0,故s2 > s1
//		//compareToIgnoreCase(String str)方法->按字典顺序比较两个字符串，忽略大小写差异
//		System.out.println(s1.compareToIgnoreCase(s2));//0
//
//		//concat(String str)方法->将指定的字符串连接到此字符串的末尾。但是无法对s1本身操作，还不如用+连接呢
//		System.out.println(s1.concat("!!"));//hello!!
//
//		//contains(CharSequence s)方法->当且仅当此字符串包含指定的char值序列时，才返回true。
//		//注意到contains()方法的参数是CharSequence而不是String，因为CharSequence是String实现的一个接口。
//		//CharSequence是char值的可读序列。该接口提供对许多不同类型的char序列的统一，只读访问。
//		System.out.println(s1.contains("he"));//ture
//		System.out.println(s1.contains("helo"));//false
//
//		//equals(Object anObject)方法->将此字符串与指定的对象进行比较。
//		System.out.println(s1.equals(s2));//false
//		//equalsIgnoreCase(String anotherString)方法->将此 String与另一个 String比较，忽略了大小写。
//		System.out.println(s1.equalsIgnoreCase(s2));//true
//
//		//format(String format, Object... args)方法->使用指定的格式字符串和参数返回格式化字符串。
//		System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));//Hi Bob, your score is 59.50!
//		//formatted(Object... args)方法->Formats using this string as the format string, and the supplied arguments.使用此字符串作为格式字符串的格式，以及提供的参数。
//		String s = "Hi %s, your score is %d!";
//		System.out.println(s.formatted("Alice", 80));//Hi Alice, your score is 80!
//		//有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：
//		//%s：显示字符串；
//		//%d：显示整数；
//		//%x：显示十六进制整数；
//		//%f：显示浮点数。
//		//占位符还可以带格式，例如%.2f表示显示两位小数。如果你不确定用啥占位符，那就始终用%s，因为%s可以显示任何数据类型。
//
//		//indexOf(int ch)方法->返回指定字符第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf('h'));//0
//		System.out.println(s1.indexOf('l'));//2
//		System.out.println(s1.indexOf('a'));//-1
//		//indexOf(int ch, int fromIndex)方法->返回指定字符第一次出现的此字符串中的索引，从指定索引处开始搜索。
//		System.out.println(s1.indexOf('l', 3));//3
//		System.out.println(s1.indexOf('h', 3));//-1
//		//indexOf(String str)方法->返回指定子字符串第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf("el"));//1
//		System.out.println(s1.indexOf("eo"));//-1
//		//indexOf(String str, int fromIndex)方法->从指定的索引处开始，返回指定子字符串第一次出现的字符串中的索引。
//		System.out.println(s1.indexOf("ll", 2));//2
//		System.out.println(s1.indexOf("ll", 3));//-1
//
//		//isBlank()方法->如果字符串为空或仅包含 white space代码点，则返回 true ，否则 false 。
//		System.out.println(s1.isBlank());//false
//		//isEmpty()方法->返回 true，当且仅当，length()是 0 。
//		System.out.println(s1.isEmpty());//false
//
//		//join(CharSequence delimiter, CharSequence... elements)方法->返回由 CharSequence elements的副本组成的新String，该副本与指定的 delimiter的副本连接在一起。
//		System.out.println(String.join("!!", s1, s2, s1, s2));//hello!!Hello!!hello!!Hello
//		String[] arr = {"h", "e", "l", "l", "o"};
//		System.out.println(String.join("!", arr));//h!e!l!l!o
//
//		//lastIndexOf(int ch)方法->返回指定字符最后一次出现的字符串中的索引。
//		//lastIndexOf(int ch, int fromIndex)方法->返回指定字符最后一次出现的字符串中的索引，从指定的索引开始向后搜索。
//		//lastIndexOf(String str)方法->返回指定子字符串最后一次出现的字符串中的索引。
//		//lastIndexOf(String str, int fromIndex)方法->返回指定子字符串最后一次出现的字符串中的索引，从指定索引开始向后搜索。
//
//		//length()方法->返回此字符串的长度。
//		System.out.println(s1.length());//5
//
//		//repeat(int count)方法->返回一个字符串，其值为此字符串的串联重复 count次。
//		System.out.println(s1.repeat(3));//hellohellohello
//
//		//replace(char oldChar, char newChar)方法->返回从替换所有出现的导致一个字符串 oldChar在此字符串 newChar 。
//		System.out.println(s1.replace('l', 'L'));//heLLo
//		//replace(CharSequence target, CharSequence replacement)方法->将此字符串中与文字目标序列匹配的每个子字符串替换为指定的文字替换序列。
//		System.out.println(s1.replace("hel", "HEL"));//HELlo
//		//replaceAll(String regex, String replacement)方法->将给定替换的给定 regular expression匹配的此字符串的每个子字符串替换。
//		String s4 = "A,,B;C ,D";
//		System.out.println(s4.replaceAll("[,;\\s]+", ",")); // A,B,C,D
//
//		//split(String regex)方法->将此字符串拆分为给定 regular expression的匹配 项 。
//		String s5 = "A,B,C,D";
//		String[] ss1 = s5.split(",");
//		System.out.println(ss1[1]);//B
//
//		//startsWith(String prefix, int toffset)方法->测试从指定索引开始的此字符串的子字符串是否以指定的前缀开头。
//		System.out.println(s1.startsWith("he"));//true
//
//		//strip()方法->返回一个字符串，其值为此字符串，并删除了所有前导和尾随空白字符，空白字符包括任何空格（包括\u3000），\t，\r，\n。
//		System.out.println("  \u3000\tHello\r\n ".strip());//Hello
//		//stripLeading()方法->返回一个字符串，其值为此字符串，并删除了所有前导 white space 。
//		System.out.println("  \tHello\r\n ".stripLeading());//Hello<CR><CR>
//		//stripTrailing()方法->返回一个字符串，其值为此字符串，并删除所有尾随 white space 。
//		System.out.println("  \tHello\r\n ".stripTrailing());//  	Hello
//
//		//substring(int beginIndex)方法->返回一个字符串，该字符串是此字符串的子字符串。
//		System.out.println(s1.substring(1));//ello
//		//substring(int beginIndex, int endIndex)方法->返回一个字符串，该字符串是此字符串的子字符串。
//		System.out.println(s1.substring(1, 3));//el,左闭右开[a,b)
//
//		//toCharArray()方法->将此字符串转换为新的字符数组。
//		char[] ss2 = s1.toCharArray();
//		System.out.println(ss2[2]);//l
//
//		//toLowerCase()方法->使用默认语言环境的规则将此 String所有字符转换为小写。
//		System.out.println(s2.toLowerCase());//hello
//		//toUpperCase()方法->使用默认语言环境的规则将此 String所有字符转换为大写。
//		System.out.println(s1.toUpperCase());//HELLO
//
//		//trim()方法->返回一个字符串，其值为此字符串，删除了所有前导和尾随空格，其中space被定义为其代码点小于或等于 'U+0020' （空格字符）的任何字符。
//		System.out.println("\u3000Hello\u3000".trim()); // "　Hello　",3000>2000,无法删除
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		char[] a = new char[62];
//		int i = 0;
//		for (char j = 'A'; j <= 'Z'; i++, j++) {
//			a[i] = j;
//		}
//		for(int j = 0;j<i;j++)
//		System.out.println(a[j]);
//	}
//}


//import java.util.Random;
//
//public class Main {
//	public static void main(String[] args) {
//		Random random = new Random();
//		System.out.println("nextInt()：" + random.nextInt()); // 随机生成一个整数，这个整数的范围就是int类型的范围-2^31~2^31-1
//		System.out.println("nextLong()：" + random.nextLong()); // 随机生成long类型范围的整数
//		System.out.println("nextFloat()：" + random.nextFloat()); // 随机生成[0, 1.0)区间的小数
//		System.out.println("nextDouble()：" + random.nextDouble()); // 随机生成[0, 1.0)区间的小数
//		System.out.println("nextBoolean()：" + random.nextBoolean());//随机生成一个boolean值，生成true和false的值几率相等，也就是都是50%的几率
//		System.out.println("nextGaussian():" + random.nextGaussian());//随机生成呈高斯（“正态”）分布的 double 值，其平均值是 0.0，标准差是 1.0
//		byte[] byteArr = new byte[5];
//		random.nextBytes(byteArr); // 随机生成byte，并存放在定义的数组中，生成的个数等于定义的数组的个数
//		System.out.print("nextBytes()：");
//		for (int i = 0; i < byteArr.length; i++) {
//			System.out.print(byteArr[i] + "\t");
//		}
//		System.out.println();
//		/**
//		 * random.nextInt(n)
//		 * 随机生成一个正整数，整数范围[0,n),包含0而不包含n
//		 * 如果想生成其他范围的数据，可以在此基础上进行加减
//		 * 例如：
//		 * 1. 想生成范围在[0,n]的整数
//		 *         random.nextInt(n+1)
//		 * 2. 想生成范围在[m,n]的整数, n > m
//		 *         random.nextInt(n-m+1) + m
//		 *         random.nextInt() % (n-m) + m
//		 * 3. 想生成范围在(m,n)的整数
//		 *         random.nextInt(n-m+1) + m -1
//		 *         random.nextInt() % (n-m) + m - 1
//		 * ......主要是依靠简单的加减法
//		 */
//		System.out.println("nextInt(10)：" + random.nextInt(10)); // 随机生成一个整数，整数范围[0,10)
//		for (int i = 0; i < 5; i++) {
//			System.out.println("我生成了一个[3,15)区间的数，它是：" + (random.nextInt(12) + 3));
//		}
//		/**
//		 * random.nextDouble()
//		 * 例如:
//		 * 1.生成[0,1.0)区间的小数
//		 *         double d1 = random.nextDouble();//直接使用nextDouble方法获得。
//		 * 2.生成[0,5.0)区间的小数
//		 *           double d2 = random.nextDouble() * 5;//因为扩大5倍即是要求的区间。同理，生成[0,d)区间的随机小数，d为任意正的小数，则只需要将nextDouble方法的返回值乘以d即可。
//		 * 3.生成[1,2.5)区间的小数
//		 *         double d3 = r.nextDouble() * 1.5 + 1;//生成[1,2.5)区间的随机小数，则只需要首先生成[0,1.5)区间的随机数字，然后将生成的随机数区间加1即可。
//		 * ......同理，生成任意非从0开始的小数区间[d1,d2)范围的随机数字(其中d1不等于0)，则只需要首先生成[0,d2-d1)区间的随机数字，然后将生成的随机数字区间加上d1即可。
//		 *
//		 */
//	}
//}


//import java.util.Random;
//public class Main {
//	public void random() {
//		int i = 0;
//		int j = 0;
//		Random random = new Random(1);
//		Random random1 = new Random(1);
//		i = random.nextInt();
//		j = random1.nextInt();
//		System.out.println("i:" + i + "\nj:" + j);
//	}
//	public static void main(String[] args) {
//		Main tt = new Main();
//		tt.random();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		// String substring(int start,int end)
//		// 截取字符串，传入的两个参数分别为要截取边界的下标
//		// 在java api 中,通常使用两个数字表示范围时,都是含头不含尾,即包含起始下标对应的内容,但不包含结束下标的处对应的内容
//		// String toUpperCase() 将当前字符串中的英文部分转换为全大写
//		/********* Begin *********/
//		int x1=str.indexOf(".")+1;
//		int x2=str.indexOf(".",x1);
//		//x2的意思为从指定索引处开始，返回第一次出现的指定字符串中的索引
//		//通俗意思是先从指定处x1开始查找，直到查到该指定字符串，然后返回该字符串的索引
//		String a=str.substring(x1,x2);
//		System.out.println(a);
//		String b=a.toUpperCase();
//		System.out.println(b);
//		/********* End *********/
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		method(
//				new Animal() {
//					@Override
//					public void eat() {
//						System.out.println("狗吃骨头");
//					}
//				}
//		);
//	}
//
//	public static void method(Animal a) {
//		a.eat();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Person p = new Student();
////		System.out.println(p.name);
//		Student q = (Student) p;
//		q.sout();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		show(new Cat()); // 以 Cat 对象调用 show 方法
//		show(new Dog()); // 以 Dog 对象调用 show 方法
//		Animal a = new Cat(); // 向上转型
//		a.eat(); // 调用的是 Cat 的 eat
//		Cat c = (Cat) a; // 向下转型
//		c.work(); // 调用的是 Cat 的 work
//	}
//
//	public static void show(Animal a) {
//		a.eat();
//// 类型判断
//		if (a instanceof Cat) { // 猫做的事情
//			Cat c = (Cat) a;
//			c.work();
//		} else if (a instanceof Dog) { // 狗做的事情
//			Dog c = (Dog) a;
//			c.work();
//		}
//	}
//}
//
//abstract class Animal {
//	abstract void eat();
//}
//
//class Cat extends Animal {
//	public void eat() {
//		System.out.println("吃鱼");
//	}
//
//	public void work() {
//		System.out.println("抓老鼠");
//	}
//}
//
//class Dog extends Animal {
//	public void eat() {
//		System.out.println("吃骨头");
//	}
//
//	public void work() {
//		System.out.println("看家");
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		GirlFriend gf1 = new GirlFriend();
//		gf1.setAge(16);
//		System.out.println(gf1.getAge());
//		Scanner sc = new Scanner(System.in);
//		String name = sc.next();
//		String sex = sc.next();
//		Person p = new Person();
//		Person q = new Person(name,sex);


//		WuMingFen f1 = new WuMingFen("牛肉",3,true);
//		WuMingFen f2 = new WuMingFen("牛肉",3);
//		WuMingFen f3 = new WuMingFen();
//		f1.check();
//		f2.check();
//		f3.check();


//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		eat();
//	}
//	public  static  void sleep(){
//		System.out.println("睡觉");
//	}
//	public  static  void study(){
//		System.out.println("学习");
//	}
//	public  static  void  eat(){
//		study();
//		System.out.println("吃饭");
//		sleep();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		print666();
//		print666();
//	}
//
//	public static void print666() {
//		System.out.println("666");
//	}
//
//	public static void compare(int a, int b) {
//		System.out.println(a == b);
//	}
//
//	public static void compare(double a, double b) {
//		System.out.println(a == b);
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
//		System.out.println(arr);
//	}
//}


//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = 5;
//		int i, j, temp, min = 0;
//		int[] array;
//		array = new int[n];
//		for (i = 0; i < n; i++) {
//			array[i] = sc.nextInt();
//		}
//		System.out.println("The sequence before sorted:");
//		for (i = 0; i < n - 1; i++) {
//			min = i;
//			for (j = i + 1; j < n; j++) {
//				if (array[min] > array[i]) {
//					min = j;
//				}
//				if (min != i) {
//					temp = array[min];
//					array[min] = array[i];
//					array[i] = temp;
//				}
//			}
//			System.out.println("The sequence after sorted:");
//			for (i = 0; i < n; i++) {
//				System.out.print(array[i]);
//			}
//		}
//	}
//}


////TripPlan
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n, m, k;
//		n = sc.nextInt();
//		m = sc.nextInt();
//		k = sc.nextInt();
//		int[] ti;
//		ti = new int[n];
//		int[] ci;
//		ci = new int[n];
//		int[] qi;
//		qi = new int[n];
//		int[] answer;
//		answer = new int[n];
//		for (int i = 0; i < n; i++) {
//			ti[i] = sc.nextInt();
//			ci[i] = sc.nextInt();
//		}
//		for (int i = 0; i < m; i++) {
//			qi[i] = sc.nextInt();
//		}
//		for (int j = 0; j < m; j++) {
//			answer[j] = 0;
//			for (int i = 0; i < n; i++) {
//				if (qi[j] + k <= ti[i] && ti[i] < qi[j] + k + ci[i]) {
//					answer[j]++;
//				}
//			}
//		}
//		for (int i = 0; i < m; i++) {
//			System.out.println(answer[i]);
//		}
//	}
//}

////SalaryPerWeek
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
////		System.out.println(n);
//		double[] k;
//		k = new double[n];
//		double[] t;
//		t = new double[n];
//		for (int i = 0; i < n; i++) {
//			k[i] = sc.nextDouble();
////			System.out.println(k[i]);
//			t[i] = sc.nextDouble();
////			System.out.println(t[i]);
//		}
//		for (int i = 0; i < n; i++) {
//			if (k[i] < 50) {
//				if (t[i] > 60)
//					System.out.println("该员工每小时基本工资低于50元且该员工工作时间超过60小时");
//				else
//					System.out.println("该员工每小时基本工资低于50元");
//			} else if (t[i] > 60)
//				System.out.println("该员工周工作时间超过60小时");
//			else if (t[i] < 40)
//				System.out.println(k[i] * t[i]);
//			else if (40 <= t[i] && t[i] <= 50)
//				System.out.println(k[i]*40+(t[i]-40)*k[i]*1.5);
//			else
//				System.out.println(k[i]*40+10*k[i]*1.5+(t[i]-50)*k[i]*2);
//		}
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		int f1 = 1, f2 = 1, n = 3, f3;
//		System.out.println(f1 + "\n" + f2);
//		for (; n <= 20; n++) {
//			f3 = f1 + f2;
//			f1 = f2;
//			f2 = f3;
//			System.out.println(f3);
//		}
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//
//		System.out.println(true & true);
//		System.out.println(false & false);
//		System.out.println(true & false);
//		System.out.println(false & true);
//
//		System.out.println(true | true);
//		System.out.println(false | false);
//		System.out.println(true | false);
//		System.out.println(false | true);
//	}
//}


// public class Main{
//     public static void main(String[] args){
// 		byte b = 10;
// 		System.out.println(b);
// 		short s =20;
// 		System.out.println(s);
// 		int i = 30;
// 		System.out.println(i);
// 		long n = 9999999999L;
// 		System.out.println(n);
// 		float f = 10.1F;
// 		System.out.println(f);
// 		double d = 20.2;
// 		System.out.println(d);
// 		char c = '中';
// 		System.out.println(c);
// 		boolean o = true;
// 		System.out.println(o);
//     }
// }


// public class Main {
//     //叫做main方法，表示程序的主入口
//     public static void main(String[] args) {
//
//         //输出语句（打印语句）
//         System.out.println("Hello world!");
//
//         //整数
//         System.out.println(666);
//         System.out.println(-777);
//
//         //小数a
//         System.out.println(1.93);
//         System.out.println(-3.71);
//
//         //字符串
//         System.out.println("王渊");
//         System.out.println("爱Java");
//
//         //字符
//         System.out.println('男');
//         System.out.println('二');
//
//         //布尔
//         System.out.println(true);
//         System.out.println(false);
//
//         //空
//         System.out.println("null");
//     }
// }


