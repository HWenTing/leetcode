package T_801_900;

public class T999 {

    public static int[] getpos(char[][] board) {
        for(int i=0;i<8;i++){
        	for(int j=0;j<8;j++){
        		if(board[i][j]=='R')
        			return  new int[]{i,j};
        	}
        }
        return new int[]{-1,-1};
    }
    
    public int numRookCaptures(char[][] board) {
    	int[] pos = getpos(board);
    	int row = pos[0];
    	int col = pos[1];
    	int ans=0;
//    	up
    	for(int i=row-1;i>=0;i--){
    		if(board[i][col]=='.')
    			continue;
    		else if(board[i][col]=='p')
    			ans++;
    		break;
    	}
    	
//    	down
    	for(int i=row+1;i<8;i++){
    		if(board[i][col]=='.')
    			continue;
    		else if(board[i][col]=='p')
    			ans++;
    		break;
    	}
    	
//    	left
    	for(int j=col-1;j>=0;j--){
    		if(board[row][j]=='.')
    			continue;
    		else if(board[row][j]=='p')
    			ans++;
    		break;
    	}
    	
//    	right
    	for(int j=col+1;j<8;j++){
    		if(board[row][j]=='.')
    			continue;
    		else if(board[row][j]=='p')
    			ans++;
    		break;
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args){
    	char [][] a = new char[][]{
    	    {'.','.','.','.','.','.','.','.'},
    	     {'.','.','.','p','.','.','.','.'},
			{'.','.','.','p','.','.','.','.'},
    	     {'p','p','.','R','.','p','B','.'},
    	     {'.','.','.','.','.','.','.','.'},
    	     {'.','.','.','B','.','.','.','.'},
    	     {'.','.','.','p','.','.','.','.'},
    	     {'.','.','.','.','.','.','.','.'}
    	};
    	T999 t = new T999();
    	
    	System.out.println(t.numRookCaptures(a));
    	
    	
    }
//    [['.','.','.','.','.','.','.','.'],
//     ['.','.','.','p','.','.','.','.'],
//     ['.','.','.','p','.','.','.','.'],
//     ['p','p','.','R','.','p','B','.'],
//     ['.','.','.','.','.','.','.','.'],
//     ['.','.','.','B','.','.','.','.'],
//     ['.','.','.','p','.','.','.','.'],
//     ['.','.','.','.','.','.','.','.']]
    		
}
