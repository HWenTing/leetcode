package T_501_600;

import java.util.HashMap;
import java.util.HashSet;

public class T532 {

	public int findPairs(int[] nums, int k) {
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		if (k == 0) {
			for (int num : nums) {
				map.put(num, map.getOrDefault(num, 0));
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
