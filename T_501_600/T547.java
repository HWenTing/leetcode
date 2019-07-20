package T_501_600;

public class T547 {
//这个题和之前的岛屿问题不大一样，这个有传递性
	
    public int findCircleNum(int[][] M) {
    	int N = M.length;
    	boolean[] marked = new boolean[N];
    	int ans = 0;
    	for(int i=0;i<N;i++){
    		if(!marked[i]){
    			ans++;
    			dfs(M,marked,i);
    		}
    	}
    	return ans;
    }
     
    private void dfs(int[][] M,boolean[] marked,int pos){
    	
    	marked[pos] = true;
    	for(int j = 0;j<marked.length;j++){
			if(M[pos][j]==1 && !marked[j]){
				dfs(M,marked,j);
			}
		}
    }
    public static void main(String[] args){
    	T547 t = new T547();
    	int[][] grid = {
    			{1,0,0,1},
    			{0,1,1,0},
    			{0,1,1,1},
    			{1,0,1,1}};
    	
    	System.out.println(t.findCircleNum(grid));	
    }
}
