package T1k_201_NOW;

public class T1219 {

//	你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
//	每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
//
//	为了使收益最大化，矿工需要按以下规则来开采黄金：
//
//	每当矿工进入一个单元，就会收集该单元格中的所有黄金。
//	矿工每次可以从当前位置向上下左右四个方向走。
//	每个单元格只能被开采（进入）一次。
//	不得开采（进入）黄金数目为 0 的单元格。
//	矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
	
//	回溯算法
	private int X,Y;
    public int getMaximumGold(int[][] grid) {
    	Y = grid.length;
    	X = grid[0].length;
    	
        boolean[][] marked = new boolean[Y][X];//其实是可以省略掉标记数组marked，只需要再回溯时把当前的改为0，结束当前回溯时再修改回去即可
        int max = 0;
        
        for(int i=0;i<Y;i++){
        	for(int j=0;j<X;j++){
        		if(grid[i][j]>0)
        			max = Math.max(max, flashBack(grid,marked,i,j));
        	}
        }
        return max;
        
    }

    private int[][] directs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
	private int flashBack(int[][] grid, boolean[][] marked, int i, int j) {
		marked[i][j]=true;
		int max=0;
		for(int[] d:directs){
			int newi = i+d[0];
			int newj = j+d[1];
			if(valid(newi,newj) && grid[newi][newj]>0 && !marked[newi][newj]){
				max = Math.max(max, flashBack(grid,marked,newi,newj));
			}
		}
		
		marked[i][j]=false;
		return max+grid[i][j];
	}
    
	private boolean valid(int i,int j){
		return i>=0 && j>=0 && i<Y && j<X;
	}
}
