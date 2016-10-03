/**
 * @version 1.0
 * @date    2016年9月27日
 * @author  ZesinWong@gmail.com
 */

import java.util.*;

public class RandomizedSet {
	Map<Integer, Integer> m;
	ArrayList<Integer> arrayList;
	Random rand;
	
    /** Initialize your data structure here. */
	public RandomizedSet() {
		m = new HashMap<Integer, Integer>();
		arrayList = new ArrayList<Integer>();
		rand = new Random();
	}

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (m.containsKey(val))
			return false;
		else {// hashmap中不含val，则在m中建立新的映射，在list中添加val
			int len = arrayList.size();
			m.put(val, len);
			arrayList.add(val);
			return true;
		}
	}
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!m.containsKey(val))
			return false;
		else {// 不能直接remove，否则添加时索引可能重叠，这就是需要list的原因
			int pos = m.get(val);
			int len = arrayList.size();
			int last = arrayList.get(len - 1);
			if (pos != len - 1) {// val不是list中最后一个元素
				m.put(last, pos);
				// m.put(val,len-1);//交换映射关系,因为remove(key)，所以即使不交换也可以
				arrayList.set(pos, last);
			}
			m.remove(val);
			arrayList.remove(len - 1);
			return true;
		}
	}
    
    /** Get a random element from the set. */
	public int getRandom() {// 利用Random()实现随机数
		return arrayList.get(rand.nextInt(arrayList.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
