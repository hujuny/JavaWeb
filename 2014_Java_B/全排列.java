import java.util.HashSet;
import java.util.Set;

public class 全排列 {
	
	 /*
	 * 用递归框架写全排列模板
	 */

	private static void f(int[] arr,int k) {
		//k，确认第几位
		if(k==3) {
			print(arr);
		}
		for(int i=k;i<arr.length;i++) {
			//将第i位和第k位交换
			int t=arr[i];
			arr[i]=arr[k];
			arr[k]=t;
			//移交下一层去确认k+1位
			f(arr,k+1);
		//回溯，换回来
			t=arr[i];
			arr[i]=arr[k];
			arr[k]=t;
			
		}
	}
	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr= {2,3,1};
		f(arr,0);
	}
	
	//实现全排列重复字符串
 /* static Set<String> set=new HashSet<String>();
	private static void f(char[] arr, int k) {
		if(k==arr.length) {
			String s = new String(arr);
			set.add(s);
		}
		for(int i=k;i<arr.length;i++) {
			char t=arr[i];
			arr[i]=arr[k];
			arr[k]=t;
			f(arr,k+1);
			t=arr[i];
			arr[i]=arr[k];
			arr[k]=t;
		}
	}
	
	public static void main(String[] args) {
		char[] arr= {'a','b','c','a'};
		f(arr,0);
		for(String s:set) {
			System.out.println(s);
		}
	}*/
	

	
}
