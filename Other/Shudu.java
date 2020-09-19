package Other;

import java.util.Stack;

public class Shudu {

//	编写一个程序，通过已填充的空格来解决数独问题。
//	一个数独的解法需遵循如下规则：
//	数字 1-9 在每一行只能出现一次。
//	数字 1-9 在每一列只能出现一次。
//	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//	空白格用 '.' 表示。
//	你可以假设给定的数独只有唯一解。
	
//	回溯
	
//	ac
    public void solveSudoku(char[][] board) {

    	int[] row = new int[9];
    	int[] col = new int[9];
    	int[] box = new int[9];
    	Stack<int[]> dots = new Stack<>();//记录未知点
    	
    	for(int i=0;i<9;i++){
    		for(int j = 0;j<9;j++){
    			if(board[i][j]!='.'){
    				int num = board[i][j]-'1';
    				row[i] |= (1<<num);
    				col[j] |= (1<<num);
    				box[(i/3)*3 +j/3] |= (1<<num);
    			}else{
    				dots.push(new int[]{i,j});
    			}
    		}
    	}
    	dfs(board,row,col,box,dots);
    }
    
    private boolean dfs(char[][] board,int[] row,int[] col,int[] box,Stack<int[]> dots){
    	if(dots.empty()) return true;
    	
    	int[] pos = dots.pop();
    	int i = pos[0],j = pos[1];
    	for(int n=0;n<9;n++){
    		if((row[i]&(1<<n))==0 && (col[j]&(1<<n))==0 &&  (box[(i/3)*3 +j/3]&(1<<n))==0 ){
				row[i] |= (1<<n);
				col[j] |= (1<<n);
				box[(i/3)*3 +j/3] |= (1<<n);
				board[i][j] = (char)(n+'1');
				if(dfs(board,row,col,box,dots))
					return true;
				board[i][j] = '.';
				row[i] &= 65535-(1<<n);
				col[j] &= 65535-(1<<n);
				box[(i/3)*3 +j/3] &= 65535-(1<<n);
    		}
    	}
    	dots.push(pos);
    	return false;
    }
 
    
//	ac
//    public void solveSudoku(char[][] board) {
//    	int[] row = new int[9];//用int的每一位来标记0-9是否出现过
//    	int[] col = new int[9];
//    	int[] box = new int[9];
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    int num = board[i][j] - '0';
//    				row[i] |= (1<<num);
//    				col[j] |= (1<<num);
//    				box[(i/3)*3 +j/3] |= (1<<num);
//                }
//            }
//        }
//        dfs(board, row, col, box, 0, 0);
//    }
//
//    private boolean dfs(char[][] board, int[] row, int[] col, int[] block, int i, int j) {
//        // 找寻空位置
//        while (board[i][j] != '.') {
//            if (++j >= 9) {
//                i++;
//                j = 0;
//            }
//            if (i >= 9) {
//                return true;
//            }
//        }
//        for (int num = 1; num <= 9; num++) {
//            if((row[i]&(1<<num))==0 && (col[j]&(1<<num))==0 &&  (block[(i/3)*3 +j/3]&(1<<num))==0 ){
//                // 递归
//                board[i][j] = (char) ('0' + num);
//				row[i] |= (1<<num);
//				col[j] |= (1<<num);
//				block[(i/3)*3 +j/3] |= (1<<num);
//				
//                if (dfs(board, row, col, block, i, j)) {
//                    return true;
//                } else {
//                    // 回溯
//    				row[i] &= 65535-(1<<num);
//    				col[j] &= 65535-(1<<num);
//    				block[(i/3)*3 +j/3] &= 65535-(1<<num);
//                    board[i][j] = '.';
//                }
//            }
//        }
//        return false;
//    }
    
}
