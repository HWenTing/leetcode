package T_101_200;

public class T130 {
	
    public void solve(char[][] board) {
        int lenh = board.length;
        if(lenh<3)
        	return ;
        int lenw = board[0].length;

        boolean[][] marked = new boolean[lenh][lenw];
        
//        上
        for(int i=0;i<lenw;i++){
        	dfs(board,marked,0,i);
        }
//        下
        for(int i=0;i<lenw;i++){
        	dfs(board,marked,lenh-1,i);
        }
//        左
        for(int i=1;i<lenh-1;i++){
        	dfs(board,marked,i,0);
        }
//        右
        for(int i=1;i<lenh-1;i++){
        	dfs(board,marked,i,lenw-1);
        }
        
        draw(board,marked);
    }
    
    private void draw(char[][] board,boolean[][] marked){
        int lenh = board.length;
        int lenw = board[0].length;
        for(int i=0;i<lenh;i++){
        	for(int j =0;j<lenw;j++){
        		if(!marked[i][j])
        			board[i][j] = 'X';
        	}
        }
    }
    
    private void dfs(char[][] board,boolean[][] marked,int row,int col){
    	
    	if(board[row][col]=='X' ||marked[row][col] )
    		return;
    	marked[row][col]=true;
    	int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
    	for(int[] d:direct){
    		int newrow = row+d[0];
    		int newcol = col+d[1];
    		if(newrow>=0 && newrow<board.length && newcol>=0 && newcol<board[0].length)
    			dfs(board,marked,newrow,newcol);
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
	}

}
