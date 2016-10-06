/**
 * @version 1.0
 * @date    2016年10月6日
 * @author  ZesinWong@gmail.com
 */

public class Solution {
	public void moveZeroes(int[] nums) {
		int j=0;
		for(int i=0;i<nums.length;++i)
		{
			if(j<i)
				++j;
			if(0==nums[i])
			{
				if(j==nums.length-1)
					break;
				do{
					++j;
				}while(j!=nums.length-1&&0==nums[j]);
				nums[i]+=nums[j];
				nums[j]=nums[i]-nums[j];
				nums[i]-=nums[j];
			}
		}
	}
}
