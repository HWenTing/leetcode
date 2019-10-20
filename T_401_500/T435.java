package T_401_500;

import java.util.Arrays;
import java.util.Comparator;

public class T435 {

//	给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
	
	
//	按起始位置排序，如果起始位置相同，取结束位置最小的；如果后一个包含在前一个，取后一个；如果有交叉，则舍弃后一个，如果不相交，直接往后迭代
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {	
				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
        });
        
        int ans=0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int pos=1;
        while(pos<intervals.length){
        	if(intervals[pos][0]==start){
        		ans++;
        	}else{
        		if(intervals[pos][1]<=end){
        			start = intervals[pos][0];
        			end = intervals[pos][1];
        			ans++;
        		}
        		else{
        			if(intervals[pos][0]<end){
        				ans++;
        			}else{
        				start = intervals[pos][0];
        				end = intervals[pos][1];
        			}
        		}
        	}
        	pos++;
        }
        return ans;
    }
	
	
//	好像理解错意思了，下面的代码是按照在覆盖范围不变的前提下，最多删除多少区间
//	按起始位置排序，如果起始位置相同，取结束位置最大的；如果起始位置不同，且终结位置不同小，忽略
//    public int eraseOverlapIntervals(int[][] intervals) {
//        
//        Arrays.sort(intervals,new Comparator<int[]>(){
//			@Override
//			public int compare(int[] o1, int[] o2) {	
//				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
//			}
//        });
//        
//        int ans=0;
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        int pos=1;
//        while(pos<intervals.length){
//        	if(intervals[pos][0]==start){
//        		ans++;
//        		end=intervals[pos][1];
//        	}else{
//        		if(intervals[pos][1]<=end)
//        			ans++;
//        		else{
//        			start = intervals[pos][0];
//        			end = intervals[pos][1];
//        		}
//        	}
//        	pos++;
//        }
//        return ans;
//    }
}
