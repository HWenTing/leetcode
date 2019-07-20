package T_401_500;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T417 {
	
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new LinkedList();
        int lenh =  matrix.length;
        if(lenh<1)
        	return ans;
        
        int lenw = matrix[0].length;

        
        boolean[][] reachP = new boolean[lenh][lenw];
        boolean[][] reachA = new boolean[lenh][lenw];
        
        for(int i =0;i<lenw;i++){
        	dfs(matrix,reachP,0,i);
        }
        for(int i =1;i<lenh;i++){
        	dfs(matrix,reachP,i,0);
        }
        
        for(int i =0;i<lenw;i++){
        	dfs(matrix,reachA,lenh-1,i);
        }
        for(int i =0;i<lenh-1;i++){
        	dfs(matrix,reachA,i,lenw-1);
        }
        
        for(int i=0;i<lenh;i++){
        	for(int j =0;j<lenw;j++){
        		if(reachA[i][j] && reachP[i][j]){
        			List<Integer> temp = new ArrayList<>();
        			temp.add(i);
        			temp.add(j);
        			ans.add(temp);
        		}
        	}
        }
        return ans;
    }
    
    private void dfs(int[][] matrix,boolean[][] reachM,int row,int col){
    	int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
    	if(reachM[row][col])
    		return;
    	reachM[row][col] = true;
    	
    	for(int[] d : direct){
    		int newrow = row+d[0];
    		int newcol = col+d[1];
    		if(newrow>=0 && newrow<matrix.length && newcol>=0 && newcol<matrix[0].length 
    				&& matrix[newrow][newcol] >=matrix[row][col] ){
    			dfs(matrix,reachM,newrow,newcol);
    		}
    	}	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
