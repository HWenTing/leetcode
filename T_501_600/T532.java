package T_501_600;

import java.util.HashMap;
import java.util.HashSet;

public class T532 {

//	给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
//	这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

	public int findPairs(int[] nums, int k) {
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		if (k == 0) {
			for (int num : nums) {
				map.put(num, map.getOrDefault(num, 0)+1);
				if (map.get(num) == 1)
					ans++;
			}
			return ans;
		}

		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int num : set) {
			if (set.contains(num + k))
				ans++;
		}

		return ans;
	}

}
