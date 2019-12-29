package T_101_200;

public class T174 {

//	错了
//	这个思路是有问题的 正着动态规划做不出来（dp 优先选择最低血量最少的）
//    public int calculateMinimumHP(int[][] dungeon) {
//       if(dungeon.length==0||dungeon[0].length==0)
//    	   return 0;
//       int[] dp = new int[dungeon[0].length];//目前的血量
//       int[] need = new int[dungeon[0].length];//道路中最低的血量
//       
//       
//       need[0] = Math.min(dungeon[0][0], 1);
//       dp[0] = -dungeon[0][0];
//       
//       for(int j=0;j<dungeon[0].length;j++){
//    	   dp[j] = dp[j-1]+dungeon[0][j];
//    	   need[j] = Math.min(dp[j], need[j-1]);
//       }
//       
//       for(int i:dp)
//    	   System.out.print(i+" ");
//       System.out.println();
//       
//       for(int i=1;i<dungeon.length;i++){
//    	   dp[0] = dp[0]+dungeon[i][0];
//		   need[0] = Math.min(dp[0], need[0]);
//		   
//    	   for(int j=1;j<dungeon[0].length;j++){
//    		   int up = Math.min(need[j], dp[j]+dungeon[i][j]);
//    		   int left = Math.min(need[j-1], dp[j-1]+dungeon[i][j]);
//    		   
//    		   if(up>left){//从上往下
//    			   dp[j] = dp[j]+dungeon[i][j];
//    			   need[j] = Math.min(dp[j], need[j]);
//    		   }else if(up<left){//从左往右
//    			   dp[j] = dp[j-1]+dungeon[i][j];
//    			   need[j] = Math.min(dp[j], need[j-1]);
//    		   }else{//从dp大的方向过来
//    			   dp[j] = Math.max(dp[j], dp[j-1])+dungeon[i][j];
//    			   need[j] = Math.min(dp[j], need[j]);
//    		   }
//    	   }
//       }
//       return need[dungeon[0].length-1]>0?1:1-need[dungeon[0].length-1];
//    }
    
	
//	要反着想dp 不是起点到ij 而是ij到终点
//	dp[i][j] 表示第[i][j]位置到终点所需的最少血量 
	public int calculateMinimumHP(int[][] dungeon) {
       if(dungeon.length==0||dungeon[0].length==0)
    	   return 0;
       int row = dungeon.length;
       int col = dungeon[0].length;
       
       int[] dp = new int[col];//目前的血量
	   
       dp[col-1] = Math.max(1,1-dungeon[row-1][col-1]);//终点位置
       for(int j=col-2;j>=0;j--){//最后一行
    	   dp[j] = Math.max(1,dp[j+1]-dungeon[row-1][j]);
       }
       for(int i=row-2;i>=0;i--){
    	   dp[col-1] = Math.max(1, dp[col-1]-dungeon[i][col-1]);
    	   for(int j=col-2;j>=0;j--){
    		   dp[j] = Math.max(1, Math.min(dp[j],dp[j+1])-dungeon[i][j]);//下方和右方中所需血量最少的
    	   }
       }
	   return dp[0];    
	}
	
	
	
	
	
	
	
	
	
	
}
