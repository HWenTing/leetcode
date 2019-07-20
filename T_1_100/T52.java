package T_1_100;

import java.util.*;
public class T52 {

	static int ans;
    public static int totalNQueens(int n) {
    	ans=0;
    	
    	char[][] chess=new char[n][n];
    	boolean[] chess_col=new boolean[n];
    	for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		chess[i][j]='.';
        	}
        	chess_col[i]=false;
    	}
    	
    	dfs(chess,chess_col,0,n);
    	
    	return ans;
    	
    }
    
    public static void   dfs(char[][] chess,boolean[] chess_col,int row,int n){
    	//如果到达递归终点;
    	if(row==n){
    		ans++;
    		return ;
    	}
    	
    	for(int i=0;i<n;i++){
    		chess[row][i]='Q';
    		if(check(chess,chess_col,row,i,n)){
    			chess_col[i]=true;
    			row++;
    			dfs(chess,chess_col,row,n);
    			row--;
    			chess_col[i]=false;
    		}
    		chess[row][i]='.';
    	}
    	
    }
    
    public static boolean check(char[][] chess,boolean[] chess_col,int row,int col,int n){
    	int step=1;
    	for(int i=row-1;i>=0;i--){
    		if(chess_col[col]){
    			return false;
    		}
    		if(col-step>=0 && chess[i][col-step]=='Q'){
    			return false;
    		}
    		
    		if(col+step<n && chess[i][col+step]=='Q'){
    			return false;
    		}
    		step++;
    	}
    	
    	return true;
    	
    }
    public static void main(String[] args){
    	System.out.println(totalNQueens(8));
    }
}
