package T_801_900;

public class T840 {
	
//	3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
//	给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

//	只有中间为5 才可能为幻方
	
    public int numMagicSquaresInside(int[][] grid) {
    	int ans=0;
        for(int i=1;i<grid.length-1;i++){
        	for(int j=1;j<grid[0].length-1;j++){
        		if(grid[i][j]==5 && check(grid,i,j))
        			ans++;
        	}
        }
        return ans;
    }

//  检查是否为幻方
	private boolean check(int[][] grid, int i, int j) {
		int[] pos=new int[10];
		int[] direct = new int[]{-1,0,1};
		for(int x:direct){
			for(int y:direct){
				int temp  = grid[i+x][j+y];
				if(temp<1 || temp>9 || pos[temp] !=0)
					return false;
				pos[temp]++;
			}
		}
		if(grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1]!=15 ||
				grid[i][j-1]+grid[i][j]+grid[i][j+1]!=15 ||
				grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1]!=15 ||
				grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1]!=15 ||
				grid[i-1][j]+grid[i][j]+grid[i+1][j]!=15 ||
				grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1]!=15 ||
				grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1]!=15 ||
				grid[i-1][j+1]+grid[i][j]+grid[i+1][j-1]!=15
				)
			return false;
		
		return true;
	}
    
    
}
