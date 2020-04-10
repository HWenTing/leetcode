package SwordToOffer;

public class T12 {
	
//	请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//	路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
//	如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

//	回溯
	
	private boolean ret;
	private int len,COL,ROW;
    public boolean exist(char[][] board, String word) {
    	
    	ROW = board.length;
    	COL = board[0].length;
    	boolean[][] marked = new boolean[ROW][COL];
    	ret = false;
    	len = word.length();
    	for(int i=0;i<ROW;i++){
        	for(int j=0;j<COL;j++){
        		dfs(board,word,marked,0,i,j);
        		if(ret) return ret;
        	}
    	}
    	return ret;
    }
    
    private void dfs(char[][] board, String word,boolean[][] marked,int pos,int row,int col){
    	if(ret || !check(row,col) || marked[row][col] || word.charAt(pos) != board[row][col]) return;
    	if(pos == len-1){
    		ret = true;
    		return;
    	}
    	
    	marked[row][col] = true;
    	//上下左右四个方向
    	dfs(board,word,marked,pos+1,row-1,col);
    	dfs(board,word,marked,pos+1,row+1,col);
    	dfs(board,word,marked,pos+1,row,col-1);
    	dfs(board,word,marked,pos+1,row,col+1);
    	marked[row][col] = false;//恢复现场
    }
    
    private boolean check(int row,int col){//检查是否越界
    	return row>=0 && col>=0 && row<ROW && col<COL;
    }
}
