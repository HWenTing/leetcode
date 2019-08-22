package T_1_100;

import java.util.HashMap;

public class T36 {

//	用hash记录出现过的元素 
//	击败55%，换为数组优化
//	public boolean isValidSudoku(char[][] board) {
//	    HashMap<Integer, Integer> [] rows = new HashMap[9];
//	    HashMap<Integer, Integer> [] columns = new HashMap[9];
//	    HashMap<Integer, Integer> [] boxes = new HashMap[9];
//	    for (int i = 0; i < 9; i++) {
//	      rows[i] = new HashMap<Integer, Integer>();
//	      columns[i] = new HashMap<Integer, Integer>();
//	      boxes[i] = new HashMap<Integer, Integer>();
//	    }
//
//	    for (int i = 0; i < 9; i++) {
//	    	for (int j = 0; j < 9; j++) {
//	    		char num = board[i][j];
//	    		if (num != '.') {
//	    			int n = (int)num;
//	    			int box_index = (i / 3 ) * 3 + j / 3;//计算第几个box
//
//	    			if (rows[i].containsKey(n)|| columns[j].containsKey(n)|| boxes[box_index].containsKey(n))
//	    				return false;
//	    			rows[i].put(n, 1);
//	    			columns[j].put(n,1);
//	    			boxes[box_index].put(n,1);
//	    		}
//	    	}
//	    }
//	    return true;
//	}
	
	
//	hash换为数组优化
//	速度击败88%，内存击败86%
	public boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][10];
		boolean[][] columns = new boolean[9][10];
		boolean[][] boxes = new boolean[9][10];

	    for (int i = 0; i < 9; i++) {
	    	for (int j = 0; j < 9; j++) {
	    		char num = board[i][j];
	    		if (num != '.') {
	    			int n = num-'1';
	    			int box_index = (i / 3 ) * 3 + j / 3;//计算第几个box

	    			if (rows[i][n]|| columns[j][n]|| boxes[box_index][n])
	    				return false;
	    			rows[i][n]=true;
	    			columns[j][n]=true;
	    			boxes[box_index][n]=true;
	    		}
	    	}
	    }
	    return true;
	}
	
}
