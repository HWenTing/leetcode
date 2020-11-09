package T_1_100;

public class T52 {

//	给定一个整数 n，返回 n 皇后不同的解决方案的数量
	
	
    private int ans,N;
    boolean[] has_column;
    boolean[] has_diagonal;//对角线  col-row+N-1
    boolean[] has_anti_diagonal;//反对角线 x+y
    
    public int totalNQueens(int n) {
        if(n<=1) return n;
        ans = 0;
        N = n;
        has_column = new boolean[n];
        has_diagonal = new boolean[2*n];
        has_anti_diagonal = new boolean[2*n];
        
        dfs(0);
        return ans;
    }

    private void dfs(int layer){
        if(layer==N){
            ans++;
            return;
        }
        for(int i=0;i<N;i++){
            if(check(layer,i)){
            	has_column[i] = true;
            	has_diagonal[i-layer+N-1] = true;
            	has_anti_diagonal[layer+i] = true;
                dfs(layer+1);
                has_column[i] =false;
                has_diagonal[i-layer+N-1] =false;
                has_anti_diagonal[layer+i] =false;
            }
        }
    }

    private boolean check(int y,int x){
    	if(has_column[x] || has_diagonal[x-y+N-1] || has_anti_diagonal[x+y])
            return false;
        return true;
    }
}
