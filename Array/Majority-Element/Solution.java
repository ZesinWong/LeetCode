import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @date 2016年10月7日
 * @author ZesinWong@gmail.com
 */

public class Solution {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		for (int num : nums) {
			if (!map.containsKey(num))
				map.put(num, 1);
			else
				map.put(num, map.get(num) + 1);
			if (map.get(num) > nums.length / 2) {
				result = num;
				break;
			}
		}
		return result;
	}
}
