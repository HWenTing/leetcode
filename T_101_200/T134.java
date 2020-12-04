package T_101_200;

public class T134 {

	
//	在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//	你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//	如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//	说明: 
//	如果题目有解，该答案即为唯一答案。
//	输入数组均为非空数组，且长度相同。
//	输入数组中的元素均为非负数。
	
	
//	从右往左，计算gas[i]-cost[i] 最大值出现的地方 最可能的起始位置  
//	感觉并不是很好理解
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int maxval=Integer.MIN_VALUE;
//        int maxpos=cost.length-1;
//        int val=0;
//        for(int i=cost.length-1;i>=0;i--){
//        	val+=(gas[i]-cost[i]);
//        	if(val>=maxval){
//        		maxpos=i;
//        		maxval=val;
//        	}
//        }
//
//        int retain=0;
//        for(int i=0;i<cost.length-1;i++){
//        	retain+=gas[maxpos];
//        	if(retain<cost[maxpos])
//        		return -1;
//        	retain-=cost[maxpos];
//        	maxpos = (maxpos+1)%cost.length;
//        }
//        return maxpos;
//    }
    
//	从0开始，寻找第一个无法到达的加油站x，那么说明这一段无法自己满足，同样对于任意0<i<x 也无法自己满足
//	那么下一次从x+1开始寻找，寻找第一个无法到达的加油站y,如果发现找了一圈都可以满足，那么这就是答案，否则就从y+1开始寻找，
//	如果到了末尾还是无法满足，那么返回-1
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	
    	int costsum =0;
    	int gassum = 0;
    	int x =0;
    	int len = gas.length;
    	
    	while(x<len){
    		int cnt = 0;
            costsum =0;gassum = 0;
    		while(cnt<len && gassum>=costsum){
    			costsum+=cost[(cnt+x)%len];
    			gassum+=gas[(cnt+x)%len];
    			cnt++;
    		}
    		if(cnt==len && gassum>=costsum)
    			return x;
    		else
    			x +=cnt;
    	}
    	return -1;
    }
    
}






