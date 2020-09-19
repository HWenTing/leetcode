package T_1_100;

public class T79 {

//	给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

//	回溯
    public boolean exist(char[][] board, String word) {
    	int lenh = board.length;
    	if(lenh==0)
    		return false;
    	int lenw = board[0].length;
    	
    	boolean[][] marked = new boolean[lenh][lenw];
        for(int i=0;i<lenh;i++){
        	for(int j=0;j<lenw;j++){
        		if(canfind(0,board,marked,i,j,word)){
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private boolean canfind(int cur,char[][] board,boolean[][] marked,int row,int col,String word){
    	if(cur == word.length())
    		return true;
    	if(row<0 || row>=board.length || col<0 || col>=board[0].length
    			||marked[row][col] || word.charAt(cur)!=board[row][col])
    		return false;
    	marked[row][col] = true;

    	int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
    	for(int[] d:direct){
    		int newrow = row+d[0];
    		int newcol = col+d[1];
    		
			cur++;
			if(canfind(cur,board,marked,newrow,newcol,word))
				return true;
			cur--;
    		
    	}
    	marked[row][col] = false;
    	return false;
    }
    
	public static void main(String[] args) {
		T79 t = new T79();
//		char[][] a = {
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}}; 
		char[][] a = {{'A'}};
		System.out.println(t.exist(a, "A"));
	}

}
