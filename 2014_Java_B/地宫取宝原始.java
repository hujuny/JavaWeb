import java.util.Scanner;

/*
 * 采用原始地宫取宝算法会产生资源限定的问题。
 * 使用记忆型递归会解决重复子问题，解决资源限定问题。
 * 动态规划数组大小会更优。
 */

/*
 * 【数据格式】

    输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)

    接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值

    要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。

例如，输入：
2 2 2
1 2
2 1
程序应该输出：
2

再例如，输入：
2 3 2
1 2 3
2 1 5
程序应该输出：
14

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms

 */
public class 地宫取宝原始 {

	private static final long MOD = 1000000007;
	private static int[][] a;
	private static int n;
	private static int m;
	private static int k;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = input.nextInt();
			}
		}

		/*初始化
		 * for (int i = 0; i < 51; i++) {
			for (int j = 0; j < 51; j++) {
				for (int l = 0; l < 14; l++) {
					for (int o = 0; o < 14; o++) {
						cache[i][j][l][o] = -1;
					}
				}
			}
		}*/

		long ans = dfs(0, 0, -1, 0);
		System.out.println(ans);
	}

	// static long[][][][] cache=new long[51][51][14][14];
	private static long dfs(int x, int y, int max, int cnt) {
		// if(cache[x][y][max+1][cnt]!=-1)return cache[x][y][max+1][cnt];
		if (x == n || y == m || cnt > k)
			return 0;
		int cur = a[x][y];
		int ans = 0;
		if (x == n - 1 && y == m - 1) {
			if (cnt == k || cnt == k - 1 && cur > max)
				return 1;
			return ans;
		}
		if (cur > max) {
			ans += dfs(x + 1, y, cur, cnt + 1);
			ans += dfs(x, y + 1, cur, cnt + 1);
		}
		ans += dfs(x + 1, y, max, cnt);
		ans += dfs(x, y + 1, max, cnt);
		// cache[x][y][max+1][cnt]=ans%MOD;
		// return ans;
		return ans % MOD;

	}
}
