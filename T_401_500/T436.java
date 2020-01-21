package T_401_500;

import java.util.Arrays;
import java.util.HashMap;

public class T436 {

//	给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
//	对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
//	注意:
//	你可以假设区间的终点总是大于它的起始点。
//	你可以假定这些区间都不具有相同的起始点。

//	双数组 intervals，按照起点排序 endIntervals，按照终点排序
    public int[] findRightInterval(int[][] intervals) {
    	int[][] endIntervals = Arrays.copyOf(intervals, intervals.length);
    	
        HashMap<int[], Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(endIntervals, (a, b) -> a[1] - b[1]);
        int j = 0;
        int[] res = new int[intervals.length];
        for (int i = 0; i < endIntervals.length; i++) {
            while (j < intervals.length && intervals[j][0] < endIntervals[i][1]) {
                j++;
            }
            res[hash.get(endIntervals[i])] = j == intervals.length ? -1 : hash.get(intervals[j]);
        }
        return res;
    }

    
}
