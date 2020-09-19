package T_101_200;

public class T130 {
	
//	给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//	找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
	
//	对上下左右四个边界的 'O'进行dfs(或者bfs) 能够访问到的 'O'置为'-' 
//	最后遍历整个数组，将'O'变成'X'  '-'变成'O'
    public void solve(char[][] board) {
        int lenh = board.length;
        if(lenh<3)
        	return ;
        int lenw = board[0].length;
        for(int i=0;i<lenw;i++){// 上下
        	dfs(board,0,i);
        	dfs(board,lenh-1,i);
        }
        for(int i=1;i<lenh-1;i++){//左右
        	dfs(board,i,0);
        	dfs(board,i,lenw-1);
        }
        for(int i=0;i<lenh;i++){//恢复
        	for(int j =0;j<lenw;j++){
        		if(board[i][j]=='O')
        			board[i][j]='X';
        		else if(board[i][j]=='-')
        			board[i][j]='O';
        	}
        }
    }
    
    private int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
    private void dfs(char[][] board,int row,int col){
    	if(board[row][col]=='X' ||board[row][col]=='-' )
    		return;
    	board[row][col]='-';
    	for(int[] d:direct){
    		int newrow = row+d[0];
    		int newcol = col+d[1];
    		if(newrow>=0 && newrow<board.length && newcol>=0 && newcol<board[0].length)
    			dfs(board,newrow,newcol);
    	}
    }


}
