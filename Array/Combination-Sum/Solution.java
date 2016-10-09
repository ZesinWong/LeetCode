import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @date    2016年10月9日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);// step one : candidate numbers sort
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), candidates, target, 0);// step two:recursive
		return result;
	}

	public void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidate, int target, int start) {
		if (0 == target)
			result.add(new ArrayList<Integer>(cur));
		else if (0 < target) {
			for (int index = start; index != candidate.length && target >= candidate[index]; ++index) {
				cur.add(candidate[index]);
				getResult(result, cur, candidate, target - candidate[index], index);
				cur.remove(cur.size() - 1);
			} // for
		} // else if
	}
}
