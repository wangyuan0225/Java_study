public class Main {
	public static void main(String[] args) {
		int f1 = 1, f2 = 1, n = 3, f3;
		System.out.println(f1 + "\n" + f2);
		for (; n <= 20; n++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			System.out.println(f3);
		}
	}
}


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


