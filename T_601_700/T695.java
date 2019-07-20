package T_601_700;




public class T695 {

    public int maxAreaOfIsland(int[][] grid) {
    	int lenw = grid[0].length;
    	int lenh = grid.length;
    	boolean[][] marked = new boolean[lenh][lenw];
    	int max = 0;
    	for(int i=0;i<lenh;i++){
    		for(int j=0;j<lenw;j++){
    			if(!marked[i][j] && grid[i][j]==1){
    				max = Math.max(max, dfs(grid,marked,i,j));
    			}
    		}
    	}
    	return max;
        
    }
    
    private int dfs(int[][] grid,boolean[][] marked,int i,int j){
    	int[][] direct = {{1,0},{-1,0},{0,-1},{0,1}};
    	marked[i][j] = true;
    	int dis = 1;
    	for(int[] d:direct){
    		int newi = i+d[0];
    		int newj = j+d[1];
    		if(newj>=0 && newj<grid[0].length && newi>=0 && newi<grid.length && 
    				!marked[newi][newj] && grid[newi][newj]==1){
    			dis+=dfs(grid,marked,newi,newj);
    		}
    		
    	}
    	return dis;
    }
    
    
    public static void main(String[] args){
    	T695 t = new T695();
    	int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
    			{0,0,0,0,0,0,0,1,1,1,0,0,0},
    			{0,1,1,0,1,0,0,0,0,0,0,0,0},
    			{0,1,0,0,1,1,0,0,1,0,1,0,0},
    			{0,1,0,0,1,1,0,0,1,1,1,0,0},
    			{0,0,0,0,0,0,0,0,0,0,1,0,0},
    			{0,0,0,0,0,0,0,1,1,1,0,0,0},
    			{0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	
    	System.out.println(t.maxAreaOfIsland(grid)	);	
    }
}
