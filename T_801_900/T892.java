package T_801_900;

public class T892 {

//	在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
//	每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
//	请你返回最终形体的表面积。
	
	
//	先求出全部的表面积，再减去重合的表面
    public int surfaceArea(int[][] grid) {
        int ans =0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]>0){
        			ans+=grid[i][j]*4+2;
        			if(i>0)//计算与上边的重合面积
        				ans-=2*Math.min(grid[i][j], grid[i-1][j]);
        			if(j>0)//计算与左边的重合面积
        				ans-=2*Math.min(grid[i][j], grid[i][j-1]);
        		}
        	}
        }
        return ans;
    }
}

        
        
        
        
        
        
        
        
        
        
        
        
        