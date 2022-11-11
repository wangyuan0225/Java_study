import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int i, j, temp, min = 0;
		int[] array;
		array = new int[n];
		for (i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("The sequence before sorted:");
		for (i = 0; i < n - 1; i++) {
			min = i;
			for (j = i + 1; j < n; j++) {
				if (array[min] > array[i]) {
					min = j;
				}
				if (min != i) {
					temp = array[min];
					array[min] = array[i];
					array[i] = temp;
				}
			}
			System.out.println("The sequence after sorted:");
			for (i = 0; i < n; i++) {
				System.out.print(array[i]);
			}
		}
	}
}
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


