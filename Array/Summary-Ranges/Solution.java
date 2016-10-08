import java.util.List;
import java.util.ArrayList;

/**
 * @version 1.0
 * @date 2016年10月8日
 * @author ZesinWong@gmail.com
 */

public class Solution {
	public List<String> summaryRanges(int[] nums) {
		if (null == nums || 0 == nums.length)
			return new ArrayList<String>();
		int index = 0;
		int head = nums[0], tail = nums[0];
		ArrayList<String> list = new ArrayList<String>();
		while (nums[index] == tail && index != nums.length) {
			if (nums[nums.length - 1] == tail) {
				if (head != tail)
					list.add(head + "->" + tail);
				else
					list.add(String.valueOf(head));// 将整型变量转化成字符串
				break;
			}
			++index;
			++tail;
			if (nums[index] != tail) {
				--tail;
				if (head != tail)
					list.add(head + "->" + tail);
				else
					list.add(String.valueOf(head));
				head = nums[index];
				tail = nums[index];
			}
		}
		return list;
	}
}
