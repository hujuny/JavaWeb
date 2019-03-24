import java.util.Scanner;

public class 菲拉波切 {
	/*static int sum;
	static int con = 0;

	public static int f(int i) {

		if (i == 1) {
			sum = 1;

		} else if (i == 2) {
			sum = 1;

		} else if (i > 2) {
			sum = f(i - 1) + f(i - 2);

		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int p = input.nextInt();
		for (int i = 1; i <= n; i++) {
			con += f(i);
		}

		System.out.println((con % f(m)) % p);

	}
*/
	
	
	 
	 	static long n, m, p;
	 	static long mularr[][] = new long[3][3];
	 	static long prev[][] = new long[3][3];
	  
	 	// a*b%p的值
	 	private static long longmul(long a, long b) {
	 		long ans = 0;
	 		while (b > 0) {
	 			long num = b & 1;
	 			if (num == 1)
	 				ans = (ans + a) % p;
	 			b = b >> 1;
	 			a = (a << 1) % p;
	 		}
	 		return ans;
	 	}
	  
	 	private static long[][] mul(long a[][], long b[][]) {
	 		long c[][] = new long[3][3];
	 		for (int i = 1; i <= 2; i++)
	 			for (int j = 1; j <= 2; j++)
	 				for (int k = 1; k <= 2; k++) {
	 					c[i][j] = (c[i][j] + longmul(a[i][k], b[k][j])) % p;
	 				}
	 		return c;
	 	}
	  
	 	private static long[][] cal(long num) {
	 		if (num == 1)
	 			return mularr;
	 		long arr[][] = cal(num / 2);
	 		arr = mul(arr, arr);
	 		if (num % 2 == 1)
	 			arr = mul(arr, mularr);
	 		return arr;
	 	}
	  
	 	private static long fib(long a) {
	 		if (a == 0)
	 			return 0;
	 		if (a <= 2)
	 			return 1;
	 		long res[][] = mul(prev, cal(a - 2));
	 		return res[1][1];
	 	}
	  
	 	private static long deal() {
	 		if (n % m == 0)
	 			return 0;
	 		long num = n / m;
	 		long fh = ((num / 2) % 2) * m % 2;
	 		if (num % 2 == 0) {
	 			if (fh == 0)
	 				return fib(n % m);
	 			else
	 				return (fib(m) - fib(n % m) + p) % p;
	 		}
	 		long num1 = fib(n % m);
	 		long num2 = fib(n % m - 1);
	 		long num3 = fib(m);
	 		long num4 = fib(m - 1);
	 		long res1 = longmul(num1, num4);
	 		long res2 = longmul(num2, num3);
	 		if (n % m % 2 == 0)
	 			res2 = (res2 - num3 + p) % p;
	 		if (fh == 0)
	 			return (res1 - res2 + p) % p;
	 		else
	 			return (res2 - res1 + p) % p;
	 	}
	  
	 	public static void main(String[] args) {
	 		// TODO Auto-generated method stub
	 		Scanner reader = new Scanner(System.in);
	 		n = reader.nextLong();
	 		m = reader.nextLong();
	 		p = reader.nextLong();
	 		mularr[1][1] = 1;
	 		mularr[1][2] = 1;
	 		mularr[2][1] = 1;
	 		mularr[2][2] = 0;
	 		prev[1][1] = 1;
	 		prev[1][2] = 1;
	 		n += 2;
	 		System.out.println((deal() - 1 + p) % p);
	 	}
	 }
