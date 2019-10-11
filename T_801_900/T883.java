package T_801_900;

public class T883 {

//	在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
//	每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
//	现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
//	投影就像影子，将三维形体映射到一个二维平面上。
//	在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
//	返回所有三个投影的总面积。

//	ans=正面每列最大值和+侧面每列最大值和+俯视不为0的个数
//    public int projectionArea(int[][] grid) {
//        int ans = 0;
//        int[] col=new int[grid[0].length];
//        
//        for(int i=0;i<grid.length;i++){
//        	int rowmax=0;
//        	for(int j=0;j<grid[0].length;j++){
//        		if(grid[i][j]>0)
//        			ans++;
//        		rowmax = Math.max(rowmax, grid[i][j]);
//        		col[j]=Math.max(col[j], grid[i][j]);
//        	}
//        	ans+=rowmax;
//        }
//        
//        for(int c:col){
//        	ans+=c;
//        }
//        return ans;
//    }
    
//	注意到N*N的方格，交换ij坐标即可计算colmax
    public int projectionArea(int[][] grid) {
        int ans = 0;
        
        for(int i=0;i<grid.length;i++){
        	int rowmax=0;
        	int colmax=0;
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]>0)
        			ans++;
        		rowmax = Math.max(rowmax, grid[i][j]);
        		colmax = Math.max(colmax, grid[j][i]);
        	}
        	ans+=rowmax+colmax;
        }
        return ans;
    }
    
}
