package T_1_100;

import java.util.Arrays;
import java.util.LinkedList;

public class T56 {
	
//	给出一个区间的集合，请合并所有重叠的区间。
//	第一反应 排序，一个个找
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        
        LinkedList<int[]> ans = new LinkedList<>();
        int anspos=0;
        
        for(int i=0;i<intervals.length;i++){
        	int left = intervals[i][0];
        	int right = intervals[i][1];
        	while(i+1<intervals.length && intervals[i+1][0]<=right){
        		right = Math.max(right, intervals[i+1][1]);
        		i++;
        	}
        	intervals[anspos]=new int[]{left,right};
        	anspos++;
        }

        return Arrays.copyOf(intervals,anspos);
    }
    
}
