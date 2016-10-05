import java.util.Arrays;

/**
 * @version 1.0
 * @date    2016年10月5日
 * @author  ZesinWong@gmail.com
 * Method：   Exclusive OR
 */

public class Solution {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int result=nums[0];
		for(int i=1;i<nums.length;++i)
		{
			result^=nums[i];
			if(0==result)
				return nums[i];
			result=nums[i];
		}
		return -1;
	}
}
