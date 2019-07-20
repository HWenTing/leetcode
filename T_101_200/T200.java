package T_101_200;

public class T200 {
//这个题要注意，char和int的区别  char类型的1，和int类型的1不一样	
	
    public int numIslands(char[][] grid) {
    	int lenh = grid.length;
    	if(lenh==0){
    		return 0;
    	}
    	int lenw = grid[0].length;
    	boolean[][] marked = new boolean[lenh][lenw];
    	for(int i=0;i<lenh;i++){
    		for(int j=0;j<lenw;j++){
    			marked[i][j] = false;
    		}
    	}
    	int max = 0;
    	for(int i=0;i<lenh;i++){
    		for(int j=0;j<lenw;j++){
    			if(!marked[i][j] && grid[i][j]=='1'){
    				max++;
    				dfs(grid,marked,i,j);
    			}
    		}
    	}
    	return max;
    }
     
    private int dfs(char[][] grid,boolean[][] marked,int i,int j){
    	int[][] direct = {{1,0},{-1,0},{0,-1},{0,1}};
    	marked[i][j] = true;
    	int dis = 1;
    	for(int[] d:direct){
    		int newi = i+d[0];
    		int newj = j+d[1];
    		if(newj>=0 && newj<grid[0].length && newi>=0 && newi<grid.length && 
    				!marked[newi][newj] && grid[newi][newj]=='1'){
    			dis+=dfs(grid,marked,newi,newj);
    		}
    		
    	}
    	return dis;
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
