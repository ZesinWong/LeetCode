import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @date 2016年10月8日
 * @author ZesinWong@gmail.com
 */

public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> contain = new HashMap<Integer, Integer>();
		for (int i = 0; i != nums.length; ++i)
			if (!contain.containsKey(nums[i]))
				contain.put(nums[i], i);
			else if (i - contain.get(nums[i]) <= k)
				return true;
			else {
				contain.put(nums[i], i);
			}
		return false;
	}
}

//Time Exceeded
/*public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i != nums.length; ++i) {
			for (int j = i; j != i + k + 1 && j != nums.length; ++j)
				if (nums[i] == nums[j] && i != j)
					return true;
		}
		return false;
	}
}*/
