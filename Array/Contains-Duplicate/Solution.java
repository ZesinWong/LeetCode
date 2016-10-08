import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @date 2016年10月8日
 * @author ZesinWong@gmail.com
 */

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> contain = new HashSet<Integer>();
		for (int num : nums)
			if (contain.contains(num))
				return true;
			else
				contain.add(num);
		return false;
	}
}
