import java.util.ArrayList;

/**
 * @version 1.0
 * @date    2016年10月7日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		if (null == nums || 0 == nums.length)
			return new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i != len; ++i)
			if (num1 == nums[i])
				++count1;
			else if (num2 == nums[i])
				++count2;
			else if (0 == count1) {
				num1 = nums[i];
				count1 = 1;
			} else if (0 == count2) {
				num2 = nums[i];
				count2 = 1;
			} else {
				--count1;
				--count2;
			}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i != len; ++i) {
			if (num1 == nums[i])
				++count1;
			else if (num2 == nums[i])
				++count2;
		}
		if (count1 > len / 3)
			result.add(num1);
		if (count2 > len / 3)
			result.add(num2);
		return result;
	}
}
