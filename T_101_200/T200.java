package T_101_200;

public class T200 {
//这个题要注意，char和int的区别  char类型的1，和int类型的1不一样	
//	击败20%，感觉有点慢
//    public int numIslands(char[][] grid) {
//    	int lenh = grid.length;
//    	if(lenh==0){
//    		return 0;
//    	}
//    	int lenw = grid[0].length;
//    	boolean[][] marked = new boolean[lenh][lenw];
//    	int max = 0;
//    	for(int i=0;i<lenh;i++){
//    		for(int j=0;j<lenw;j++){
//    			if(!marked[i][j] && grid[i][j]=='1'){
//    				max++;
//    				dfs(grid,marked,i,j);
//    			}
//    		}
//    	}
//    	return max;
//    }
//     
//    private void dfs(char[][] grid,boolean[][] marked,int i,int j){
//    	int[][] direct = {{1,0},{-1,0},{0,-1},{0,1}};
//    	marked[i][j] = true;
//    	for(int[] d:direct){
//    		int newi = i+d[0];
//    		int newj = j+d[1];
//    		if(newj>=0 && newj<grid[0].length && newi>=0 && newi<grid.length && 
//    				!marked[newi][newj] && grid[newi][newj]=='1'){
//    			dfs(grid,marked,newi,newj);
//    		}
//    		
//    	}
//    }
    
	
//下边的写法更简洁，速度也快一些，内存也少	
//	遍历岛这个二维数组，如果当前数为1，则进入感染函数并将岛个数+1
//	击败67%   尚可
    public int numIslands(char[][] grid) {
        int islandNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    infect(grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }
    //感染函数
    public void infect(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length ||
           j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
    
    public static void main(String[] args){
    	T200 t = new T200();
    	char[][] grid = {
    			{'1','1','1','1','0'},
    			{'1','1','0','1','0'},
    			{'1','1','0','0','0'},
    			{'0','0','0','0','0'}};
    	
    	System.out.println(t.numIslands(grid));	
    }
}
