import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @date    2016年10月9日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), k, n, 1);
		return result;
	}

	public void getResult(List<List<Integer>> result, List<Integer> cur, int k, int n, int start) {
		if (0 == k && 0 == n)
			result.add(new ArrayList<Integer>(cur));
		if (0 > k || 0 > n)
			return;
		if (0 < n && 0 < k) {
			for (int num = start; num <= 9 && num <= n; ++num) {
				cur.add(num);
				getResult(result, cur, k - 1, n - num, num + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
