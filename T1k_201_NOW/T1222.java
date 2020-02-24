package T1k_201_NOW;

import java.util.LinkedList;
import java.util.List;

public class T1222 {

//	在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
//	「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
//	「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
//	请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。

	
//	数组题，反向思维，从国王向各个方向找皇后
	private List<List<Integer>> ans;
	private int col,row;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
    	row = 8;
    	col = 8	;
    	ans = new LinkedList<List<Integer>>();
    	
    	boolean[][] checkerboard = new boolean[8][8];
    	for(int[] queen :queens)
    		checkerboard[queen[0]][queen[1]]=true;
    	
    	for(int i=-1; i<=1;i++)
    		for(int j=-1;j<=1;j++)
    			if(i!=0 || j!=0)
    				expand(checkerboard,king[0],king[1],i,j);

    	return ans;
    	
    }
    
    private void expand(boolean[][] checkerboard, int i,int j,int a,int b){
    	if(!valid(i,j)) return ;
    	
    	if(checkerboard[i][j])
    		ans.add(new LinkedList<Integer>(){{add(i);add(j);}});
    	else
    		expand(checkerboard,i+a,j+b,a,b);
    	
    }
    
    private boolean valid(int i,int j){
    	return i>=0 && j>=0 && i<row && j<col;
    }
    
    
}
