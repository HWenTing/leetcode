package T_501_600;

import java.util.LinkedList;
import java.util.Queue;

public class T529 {

	private int X,Y;
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
        	board[click[0]][click[1]] = 'X';
        	return board;
        }
        
        Y = board.length;
        X = board[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        
        while(!queue.isEmpty()){
        	int[] cur = queue.poll();
        	int c = count(board,cur[0],cur[1]);
        	if(c==0){
        		board[cur[0]][cur[1]]= 'B';
        		
            	for(int[] d:directs){
            		int newi = cur[0]+d[0];
            		int newj = cur[1]+d[1];
            		if(valid(newi,newj) &&board[newi][newj]=='E'){
            			queue.add(new int[]{newi,newj});
            		}
            	}
            	
        	}else
        		board[cur[0]][cur[1]] = (char)('0'+c);
        }
        return board;
    }
    
    private int[][] directs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
    
    private int count(char[][] board, int i,int j){
    	int ret=0;
    	for(int[] d:directs){
    		int newi = i+d[0];
    		int newj = j+d[1];
    		if(valid(newi,newj)){
    			if(board[newi][newj]=='M')
    				ret++;
    		}
    	}
    	return ret;
    }
    
    private boolean valid(int i,int j){
    	return i>=0 && j>=0 && i<Y && j<X;
    }
    
    
}
