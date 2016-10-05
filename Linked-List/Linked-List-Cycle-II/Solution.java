import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @date    2016年10月5日
 * @author  ZesinWong@gmail.com
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (null == head || null == head.next)
			return null;
		ListNode node = head;
		Set<ListNode> set = new HashSet<ListNode>();
		while (null != node.next) {
			if (set.contains(node))
				return node;
			set.add(node);
			node = node.next;
		}
		return null;
	}
}
