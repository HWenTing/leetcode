package T_1_100;

import java.util.*;
public class T51 {

//    public static List<List<String>> solveNQueens(int n) {
//    	List<List<String>> ans = new ArrayList<List<String>>();
//    	
//    	char[][] chess=new char[n][n];
//    	boolean[] chess_col=new boolean[n];
//    	for(int i=0;i<n;i++){
//        	for(int j=0;j<n;j++){
//        		chess[i][j]='.';
//        	}
//        	chess_col[i]=false;
//    	}
//    	
//    	dfs(ans,chess,chess_col,0,n);
//    	
//    	return ans;
//    	
//    }
//    
//    public static void dfs(List<List<String>> ans,char[][] chess,boolean[] chess_col,int row,int n){
//    	//如果到达递归终点;
//    	if(row==n){
//    		List<String> temp = new ArrayList<String>();
//    		for(int i=0;i<n;i++){
//    			String t="";
//        		for(int j=0;j<n;j++){
//        			t=t+chess[i][j];
//        		}
//        		temp.add(t);
//    		}
//    		ans.add(temp);
//    		return ;
//    	}
//    	
//    	for(int i=0;i<n;i++){
//    		chess[row][i]='Q';
//    		if(check(chess,chess_col,row,i,n)){
//    			chess_col[i]=true;
//    			row++;
//    			dfs(ans,chess,chess_col,row,n);
//    			row--;
//    			chess_col[i]=false;
//    		}
//    		chess[row][i]='.';
//    	}
//    	
//    }
//    
//    public static boolean check(char[][] chess,boolean[] chess_col,int row,int col,int n){
//    	int step=1;
//    	for(int i=row-1;i>=0;i--){
//    		if(chess_col[col]){
//    			return false;
//    		}
//    		if(col-step>=0 && chess[i][col-step]=='Q'){
//    			return false;
//    		}
//    		
//    		if(col+step<n && chess[i][col+step]=='Q'){
//    			return false;
//    		}
//    		step++;
//    	}
//    	
//    	return true;
//    	
//    }
    
	
	private boolean[] colMarked;
	private boolean[] d45Marked;
	private boolean[] d135Marked;
	
	
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<>();
    	if(n==0)
    		return res;
    	
    	colMarked = new boolean[n];
    	d45Marked = new boolean[2*n-1];
    	d135Marked = new boolean[2*n-1];
    	
    	getItem(res,0,new ArrayList<>(),n);
    	return res;
    	
    }
    
    private void getItem(List<List<String>> res,int row,List<String> temp,int n){
    	if(row==n){
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	
    	for(int i=0;i<n;i++){
    		
    		
    		if(!colMarked[i] && !d45Marked[row+i] && !d135Marked[n-1-row+i] ){
    			colMarked[i]=d45Marked[row+i] =d135Marked[n-1-row+i]=true;
    			temp.add(getcol(n,i));
    			getItem(res,++row,temp,n);
    			row--;//这个地方。。。。一定要注意啊减一啊。。。
    			
    			temp.remove(temp.size()-1);
    			colMarked[i]=d45Marked[row+i] =d135Marked[n-1-row+i]=false;
    		}
    		
    	}
    }
    
    private String getcol(int n,int pos){
    	StringBuffer b = new StringBuffer();
    	for(int i=0;i<pos;i++){
    		b.append(".");
    	}
    	b.append("Q");
    	for(int i=pos+1;i<n;i++){
    		b.append(".");
    	}
    	return b.toString();
    }
    
    public static void main(String[] args){
    	T51 t = new T51();
    	List<List<String>> temp = t.solveNQueens(0);
    	int len = temp.size();
    	for(int i=0;i<len;i++){
    		for(String s:temp.get(i)){
    			System.out.println(s);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
