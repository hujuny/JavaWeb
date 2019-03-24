import java.util.Arrays;
import java.util.Scanner;

public class 四平方和暴力解法 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N=input.nextInt();
		int[] arr=new int[4];	
		for(int a=0;a<Math.sqrt(N/4);a++) {
			for(int b=a;b<Math.sqrt(N/3);b++) {
				for(int c=b;c<Math.sqrt(N/2);c++) {
					for(int d=c;d<Math.sqrt(N);d++) {
						int sum=a*a+b*b+c*c+d*d;
						if(sum==N) {
							{
								arr[0]=a;arr[1]=b;arr[2]=c;arr[3]=d;
							}
							Arrays.sort(arr);
							System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
							return;
						}
					}
				}
			}
		}
	}
}
