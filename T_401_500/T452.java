package T_401_500;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {

//	等价于找有多少个不相交的区域  
//	
//	题解还有一种方法，按右端点排序，从最小的右端点开始，对于每一个end，箭数量加一，如果起始位置start小于等于end，则说明可以用一支箭引爆，删掉该气球的位置
//    public int findMinArrowShots(int[][] points) {
//        if(points.length==0) return 0;
//        Arrays.sort(points,new Comparator<int[]>(){
//			@Override
//			public int compare(int[] o1, int[] o2) {	
//				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
//			}
//        });
//        
//        int start = points[0][0];
//        int end = points[0][1];
//        int i=1;
//        int ans=1;
//        while(i<points.length){
//        	if(points[i][0]>=start && points[i][1]<=end){//包含
//        		start = points[i][0];
//        		end = points[i][1];
//        	}else if(points[i][0]>end){//不相交
//        		ans++;
//        		start = points[i][0];
//        		end = points[i][1];
//        	}//相交但是不包含的就不需要考虑了
//        	i++;
//        }
//        return ans;
//    }
    
    
//	题解的方法
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {	
//				return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
				return o1[1]-o2[1];//这里可简化，相同的右节点，左节点比较也没有意义了
			}
        });
        
        int end = points[0][1];
        int i=1;
        int ans=1;
        while(i<points.length){
        	if(points[i][0]>end){
        		ans++;
        		end = points[i][1];
        	}
        	i++;
        }
        return ans;
    }
    
    
}
