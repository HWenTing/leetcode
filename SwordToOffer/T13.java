package SwordToOffer;

public class T13 {

//	地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
//	一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
//	也不能进入行坐标和列坐标的数位之和大于k的格子。
//	例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
//	但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

//	dfs
	private boolean[][] marked;
    public int movingCount(int m, int n, int k) {
    	marked = new boolean[m][n];
    	return dfs(m,n,k,0,0);
    }
    
    private int dfs(int m, int n, int k,int row,int col){
    	if(row<0 || col<0 || row>=m || col>=n || marked[row][col] || !check(row,col,k)) return 0;
    	
    	marked[row][col]=true;
    	int temp = 1+dfs(m,n,k,row+1,col)+dfs(m,n,k,row-1,col)+dfs(m,n,k,row,col-1)+dfs(m,n,k,row,col+1);
    	return temp;
    	
    }
    
    private boolean check(int i,int j,int k){//判断行坐标和列坐标的数位之是否大于k
    	int temp = 0;
    	while(i>0){
    		temp+= (i%10);
    		i/=10;
    	}
    	while(j>0){
    		temp+= (j%10);
    		j/=10;
    	}
    	return temp<=k;
    }
    
}
