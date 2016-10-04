import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @version 1.0
 * @date    2016年10月4日
 * @author  ZesinWong@gmail.com
 * 思路：允许重复数字出现后，hashmap改进为val映射到hashset，
 *       hashset用于记录重复数字的位置，即其出现的顺序，需要
 *       注意的是remove操作中对hashmap和hashset的处理。
 */

public class RandomizedCollection {
	Map<Integer, Set<Integer>> map;
	ArrayList<Integer> arrayList;
	Random random;
	
    /** Initialize your data structure here. */
	public RandomizedCollection() {
		map = new HashMap<Integer, Set<Integer>>();
		arrayList = new ArrayList<Integer>();
		random = new Random();
	}

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean contain = map.containsKey(val);// contain保存状态，否则状态会改变
		if (!contain)// hashmap不含该val，则建立新的set
			map.put(val, new HashSet<Integer>());
		map.get(val).add(arrayList.size());
		arrayList.add(val);
		return !contain;
	}
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		int pos = map.get(val).iterator().next();
		map.get(val).remove(pos);
		int last = arrayList.get(arrayList.size() - 1);
		if (pos != arrayList.size() - 1) {
			map.get(last).remove(arrayList.size() - 1);
			map.get(last).add(pos);
			arrayList.set(pos, last);
		}
		arrayList.remove(arrayList.size() - 1);
		if (map.get(val).isEmpty())
			map.remove(val);
		return true;
	}
    
    /** Get a random element from the collection. */
	public int getRandom() {
		return arrayList.get(random.nextInt(arrayList.size()));
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
