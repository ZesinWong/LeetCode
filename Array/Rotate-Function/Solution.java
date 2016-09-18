/**
 * @version 1.0
 * @date    2016年9月18日
 * @author  ZesinWong@gmail.com
 */

public class Solution {// 利用相邻两项之差为∑A[i]-nA[n-i]求解
	public int maxRotateFunction(int[] A) {
		int n = A.length;
		int maxF = 0;// maxF记录F(k)的最大值
		int sum = 0;// sum记录数组A[]各元素之和
		if (n == 0)// 数组为空的情况
			return maxF;
		for (int i = 0; i != n; ++i) {// maxF初值为F(0)
			maxF += i * A[i];
			sum += A[i];
		}
		int F = maxF;// F记录F(k)的值
		for (int i = 1; i != n; ++i) {
			F += sum - n * A[n - i];// 相邻两项之差为∑A[i]-nA[n-i]求解
			if (maxF < F) {// 比较maxF与F(k)
				maxF = F;
			}
		}
		return maxF;
	}
}

/*
public class Solution {// Time Limit Exceeded
	public int maxRotateFunction(int[] A) {
		int n = A.length;
		int maxF = 0;// maxF记录F(k)的最大值
		if (n == 0)// 数组为空的情况
			return maxF;
		for (int i = 0; i != n; ++i) {// maxF初值为F(0)
			maxF += i * A[i];
		}
		for (int i = 1; i != n; ++i) {
			int F = 0;// F记录F(k)的值
			for (int j = 0; j != n; ++j) {// 每顺时针旋转一次，数组的索引减一，即为A[n+j-i]
				F += j * A[(n + j - i) % n];
			}
			if (maxF < F) {// 比较maxF与F(k)
				maxF = F;
			}
		}
		return maxF;
	}
}
*/
