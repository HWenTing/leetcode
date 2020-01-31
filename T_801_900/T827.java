package T_801_900;

import java.util.HashMap;
import java.util.HashSet;

public class T827 {

//	在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
//	进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）

//	标记 dfs 先找到所有的岛屿 然后遍历每个0，计算上下左右相邻的岛屿的最大面积和
//	特殊处理全0 或者全1的情况
	
	private int len;
    public int largestIsland(int[][] grid) {
        
    	len = grid.length;

    	HashMap<Integer,Integer> map = new HashMap<>();//标记岛屿序号与面积
    	map.put(0,0);
    	
    	int count = 2;//岛屿序号从2开始
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			if(grid[i][j]==1){
    				int size = countAndFill(count,i,j,grid);
    				map.put(count, size);
    				count++;
    			}
    		}
    	}
    	
    	int ans=0;
    	boolean allland=true;
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			if(grid[i][j]==0){
    				allland=false;
    				ans = Math.max(ans, neighbor(i,j,grid,map));
    			}
    		}
    	}
    	
    	return allland?len*len:ans+1;
    }
    
    
//  计算岛屿面积并在grid中标记岛屿序号 dfs  
    private int countAndFill(int count,int i,int j,int[][] grid){
    	if(i<0 || j<0 || i>=len ||j>=len || grid[i][j]!=1) return 0;
    	grid[i][j]=count;
    	
    	return 1+countAndFill(count,i-1,j,grid)+countAndFill(count,i,j+1,grid)+
    			countAndFill(count,i+1,j,grid)+countAndFill(count,i,j-1,grid);
    }

//    计算0 的四个方向岛屿面积之和
    private int[][] directs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int neighbor(int i,int j,int[][] grid,HashMap<Integer,Integer> map){
    	HashSet<Integer> set = new HashSet<>();
    	int ans=0;
    	
    	for(int[] d:directs){
    		int temp = valid(i+d[0],j+d[1])?grid[i+d[0]][j+d[1]]:0;
    		if(!set.contains(temp)){//属于同一个岛屿的不重复计算
    			set.add(temp);
    			ans+=map.get(temp);
    		}
    	}
    
    	return ans;
    }
    
//    判断坐标是否有效
    private boolean valid(int i,int j){
    	return i>=0 && j>=0 && i<len && j<len;
    }
}
