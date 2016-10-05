/**
 * @version 1.0
 * @date    2016年10月5日
 * @author  ZesinWong@gmail.com
 * Method：turn into a cycle detection problem
 */

public class Solution {
	public int findDuplicate(int[] nums) {
		int slow=0;
		int fast=0;
		do{
			slow=nums[slow];
			fast=nums[nums[fast]];
		}while(slow!=fast);
		slow=0;
		while(slow!=fast)
		{
			slow=nums[slow];
			fast=nums[fast];
		}
		return slow;
	}
}
