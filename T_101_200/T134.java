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
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxval=Integer.MIN_VALUE;
        int maxpos=cost.length-1;
        int val=0;
        for(int i=cost.length-1;i>=0;i--){
        	val+=(gas[i]-cost[i]);
        	if(val>=maxval){
        		maxpos=i;
        		maxval=val;
        	}
        }


        int retain=0;
        for(int i=0;i<cost.length-1;i++){
        	retain+=gas[maxpos];
        	if(retain<cost[maxpos])
        		return -1;
        	retain-=cost[maxpos];
        	maxpos = (maxpos+1)%cost.length;
        }
        return maxpos;
    }
    
    
}






