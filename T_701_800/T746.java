package T_701_800;

public class T746 {

	
//	数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//	每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//	您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

//	跳一步或者跳两步
	//	动态规划，每个状态只和前一步和前两步有关
    public int minCostClimbingStairs(int[] cost) {

    	int onecost = 0;
    	int twocost = 0;
    	
        for(int i=2;i<=cost.length;i++){
        	int temp = onecost;
        	onecost = Math.min(onecost+cost[i-1],twocost+cost[i-2]);
        	twocost = temp;
        }
        return onecost;
        
    }
    
}
