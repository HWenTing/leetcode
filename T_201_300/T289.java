package T_201_300;

public class T289 {

//	生命游戏 题目很长。。。
//	可以设置中间状态

//	0 died 
//	1 live
//	2 died->live
//	3 live->died
	
	int width,height;
    public void gameOfLife(int[][] board) {
    	height = board.length;
    	width = board[0].length;
    	
    	for(int i=0;i<height;i++){
    		for(int j=0;j<width;j++){
    			item(board,i,j);
    		}
    	}
    	
    	for(int i=0;i<height;i++){
    		for(int j=0;j<width;j++){
    			if(board[i][j]==2)
    				board[i][j]=1;
    			else if(board[i][j]==3)
    				board[i][j]=0;
    		}
    	}
    	
    }
    
    private void item(int[][] board,int i,int j){
    	int cnt=0;//记录活着的数量
    	int[][] direct = new int[][]{
    		{-1,-1},{-1,0},{-1,1},
    		{0,-1},{0,1},
    		{1,-1},{1,0},{1,1}
    	};
    	int newi,newj;
    	for(int pos=0;pos<8;pos++){
    		newi = i+direct[pos][0];
    		newj = j+direct[pos][1];
    		if(newi>=0 && newi<height && newj>=0 && newj<width){
    			if(board[newi][newj]==1 ||board[newi][newj]==3 )
    				cnt++;
    		}
    	}
    	if(board[i][j]==1 && (cnt<2 || cnt>3))
    		board[i][j]=3;
    	else if(board[i][j]==0 && cnt==3)
    		board[i][j]=2;
    }
    
}
