package T1k_1_100;

import java.util.Arrays;
import java.util.Comparator;

public class T1029 {

	
//	公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
//	返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。

	
//	先都飞往同一个地方，然后选N个人换到另一个城市，从花费差从高到低排序
//	或者按照花费差从高到低排序，前N个去A，后N个去B
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,new Comparator<int[]>(){//排序
			@Override
			public int compare(int[] o1, int[] o2) {
				int temp1 = o1[0]-o1[1]; 
				int temp2 = o2[0]-o2[1]; 
				return temp1-temp2;
			}
        });
        int ans=0;
        int N = costs.length/2;
        for(int i=0;i<N;i++){
        	ans+=costs[i][0];
        	ans+=costs[i+N][1];
        }
        return ans;
    }
    
}
