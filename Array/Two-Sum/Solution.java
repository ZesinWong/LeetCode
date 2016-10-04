import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @version 1.0
 * @date    2016年10月4日
 * @author  ZesinWong@gmail.com
 * 思路：BF的时间复杂度为O(n^2)，为了减小时间开销，
 *      决定用hashmap解决，将数值与索引映射，同时
 *      建立差数组，在map中查找差数组的值，若相同
 *      则同时记录差数组的索引和map的索引，得解。
 */

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int[] diff = new int[nums.length];
		int[] result = new int[2];
		for (int i = 0; i != nums.length; ++i) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<Integer>());
			map.get(nums[i]).add(i);
			diff[i] = target - nums[i];
		}
		for (int i = 0; i != nums.length; ++i)
			if (map.containsKey(diff[i])) {
				if (!map.get(diff[i]).contains(i))
					if (i < map.get(diff[i]).get(0)) {
						result[0] = i;
						result[1] = map.get(diff[i]).get(0);
						break;
					} else {
						result[0] = map.get(diff[i]).get(0);
						result[1] = i;
						break;
					}
				else if (2 == map.get(diff[i]).size()) {
					if (map.get(diff[i]).get(0) < map.get(diff[i]).get(1)) {
						result[0] = map.get(diff[i]).get(0);
						result[1] = map.get(diff[i]).get(1);
						break;
					} else {
						result[0] = map.get(diff[i]).get(1);
						result[1] = map.get(diff[i]).get(0);
						break;
					}
				}
			}
		return result;
	}
}
