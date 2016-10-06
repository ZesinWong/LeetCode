/**
 * @version 1.0
 * @date    2016年10月6日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public int missingNumber(int[] nums) {
		if (null == nums || 0 == nums.length)
			return -1;
		int miss = 0;
		for (int num : nums)
			miss ^= num;
		for (int i = 0; i != nums.length + 1; ++i)
			miss ^= i;
		return miss;
	}
}
