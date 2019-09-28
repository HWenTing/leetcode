package T_401_500;

public class T463 {

//	给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//	网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//	岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
    
//	水平扫描一遍，竖直扫描一遍 有0->1或1->0就加1
	
	public int islandPerimeter(int[][] grid) {
        int cnt =0;
        int before=0;
        for(int i=0;i<grid.length;i++){//水平扫描
        	before=0;
        	int j;
        	for(j=0;j<grid[i].length;j++){
        		if(before-grid[i][j]!=0){
        			cnt++;
        			before = grid[i][j];
        		}
        	}
    		if(grid[i][j-1]!=0)
    			cnt++;
        }
        
        
        for(int j=0;j<grid[0].length;j++){//竖直扫描
        	before=0;
        	int i;
        	for(i=0;i<grid.length;i++){
        		if(before-grid[i][j]!=0){
        			cnt++;
        			before = grid[i][j];
        		}
        	}
    		if(grid[i-1][j]!=0)
    			cnt++;
        }
        return cnt;
    }
    
	
//	挺妙的一种写法
//	 public int islandPerimeter(int[][] grid) {
//	        if(grid==null|| grid.length==0) return 0;
//	        int n = grid.length;
//	        int m = grid[0].length;
//	        int res = 0;
//	        for(int i = 0;i<n;i++){
//	            for(int j = 0;j<m ;j++){
//	                if(grid[i][j]==1){
//	                    res+=4;//正常来说一个方格有四条边
//	                    if(i>0 && grid[i-1][j]==1) res-=2;//和上方比，如果是1则减2
//	                    if(j>0 && grid[i][j-1]==1) res-=2;//和左方比，如果是1则减2
//	                }
//	            }
//	        }
//	        return res;
//	    }
	 
	 
}
