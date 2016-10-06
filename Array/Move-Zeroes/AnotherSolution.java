/**
 * @version 1.0
 * @date    2016年10月6日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public void moveZeroes(int[] nums) {
		if (null == nums || 0 == nums.length)
			return;
		int index = 0;
		for (int num : nums)
			if (num != 0)
				nums[index++] = num;
		while (index != nums.length)
			nums[index++] = 0;
	}
}
