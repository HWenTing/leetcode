package T_1_100;

import java.util.ArrayList;
import java.util.List;

public class T37 {

    public void solveSudoku(char[][] board) {
        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][10];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][10];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    
//先遍历一遍，拿list把需要填数的位置记录下来，回溯法 复杂度较高
//    public void solveSudoku(char[][] board) {
//    	int row = board.length;
//    	int col = board[0].length;
//    	List<int[]> need = new ArrayList<>();
//    	for(int i =0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(board[i][j]=='.')
//        			need.add(new int[]{i,j});
//        	}
//    	}
//    	for (int i=1;i<=9;i++){
//    	   int[] temp = need.remove(0);
//    	   if(huishu(need,board,temp[0],temp[1],i))
//    		   return;
//    	   need.add(0, temp);
//       }
//    }
//	
//    private boolean huishu(List<int[]> need,char[][] board,int row,int col,int k){
//
//    	if(!check(board,row,col,k)){
//    		return false;
//    	}
//    	if(need.size()==0){
//    		board[row][col] = (char)(k + '0');
//    		return true;
//    	}
//    	
//    	board[row][col] = (char)(k + '0');
//    	
//    	for(int i=1;i<=9;i++){
//    		int[] temp = need.remove(0);
//    		if(huishu(need,board,temp[0],temp[1],i)){
//    			return true;
//    		}
//    			
//    		need.add(0, temp);
//    	}
//    	
//    	board[row][col] = '.';
//    	return false;
//    	
//    }
//    
//    private boolean check(char[][] board,int row,int col,int k){
//    	return checkrow(board,row, col, k)&&checkcol(board,row,col,k)
//    			&&checkbox(board,row, col, k);
//    }
//    
//	private boolean checkrow(char[][] board,int row,int col,int k){
//		for(int i=0;i<9;i++){
//			if(board[row][i] ==(char)(k + '0') )
//				return false;
//		}
//		return true;
//	}
//	
//	private boolean checkcol(char[][] board,int row,int col,int k){
//		for(int i=0;i<9;i++){
//			if(board[i][col] ==(char)(k + '0') )
//				return false;
//		}
//		return true;
//	}
//	
//	private boolean checkbox(char[][] board,int row,int col,int k){
//		int[] d1;
//		int[] d2;
//		if(row<3){
//			d1 = new int[]{0,1,2};
//		}else if(row<6){
//			d1 = new int[]{3,4,5};
//		}else{
//			d1 = new int[]{6,7,8};
//		}
//		
//		if(col<3){
//			d2 = new int[]{0,1,2};
//		}else if(col<6){
//			d2 = new int[]{3,4,5};
//		}else{
//			d2 = new int[]{6,7,8};
//		}
//		
//		for (int i:d1){
//			for(int j:d2){
//				if(board[i][j] ==(char)(k + '0') )
//					return false;
//			}
//		}
//		return true;
//	}
	
	
	
	
    
    
    
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        T37 solution = new T37();
        solution.printBoard(board);
        solution.solveSudoku(board);
        System.out.println();
        solution.printBoard(board);
    }
}