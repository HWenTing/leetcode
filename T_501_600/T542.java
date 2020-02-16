package T_501_600;

import java.util.LinkedList;
import java.util.Queue;

public class T542 {

//	给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//	两个相邻元素间的距离为 1 。
	
//	寻找与0相邻的1的作为边缘，边缘位置标记-1 处理过的边缘当作0 不断收缩
//	bfs 
//	private int row,col;
//    public int[][] updateMatrix(int[][] matrix) {
//    	row = matrix.length;
//    	col = matrix[0].length;
//    	int[][] ans = new int[row][col];
//    	
//    	Queue<int[]> queue = new LinkedList<>();
//    	
//    	for(int i=0;i<row;i++){
//    		for(int j=0;j<col;j++){
//    			if(matrix[i][j]==1 && edge(i,j,matrix)){//寻找边界
//    				matrix[i][j] = -1;
//    				queue.add(new int[]{i,j});
//    			}
//    		}
//    	}
//
//    	int	level=0;
//    	while(!queue.isEmpty()){
//    		level++;
//    		int size = queue.size();
//    		for(int i=0;i<size;i++){
//    			int[] cur = queue.poll();
//    			if(matrix[cur[0]][cur[1]]==-1){
//    				ans[cur[0]][cur[1]] = level;
//    				matrix[cur[0]][cur[1]]=0;
//    				
//    		    	for(int[] d:directs){
//    		    		int newi = cur[0]+d[0];
//    		    		int newj = cur[1]+d[1];
//    		    		if(valid(newi,newj) && matrix[newi][newj]==1){
//    		    			matrix[newi][newj]=-1;//防止重复寻找
//    		    			queue.add(new int[]{newi,newj});
//    		    		}
//    		    	}
//    			}
//    		}
//    	}
//    	
//    	return ans;
//    	
//    }
//    
//    private int[][] directs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};//上下左右
//    private boolean edge(int i,int j,int[][] matrix){
//    	for(int[] d:directs){
//    		int newi = i+d[0];
//    		int newj = j+d[1];
//    		if(valid(newi,newj) && matrix[newi][newj]==0)
//    			return true;
//    	}
//    	return false;
//    }
//    
//    private boolean valid(int i,int j){
//    	return i>=0 && j>=0 && i<row && j<col;
//    }
	
	
//	法二 动态规划的想法
//	遍历两遍 第一遍考虑左方和上方，第二遍考虑右方和上方 , 取两遍的最小值
	
	public int[][] updateMatrix(int[][] matrix) {
		int row,col;
    	row = matrix.length;
    	col = matrix[0].length;
    	int[][] ans = new int[row][col];
    	
    	int MAX = 100001;
    	ans[0][0] = matrix[0][0]==0?0:MAX;
    	
//    	左上 到 右下
    	for(int i=1;i<col;i++){//处理第一行
    		if(matrix[0][i]==1)
    			ans[0][i] = ans[0][i-1]==MAX?MAX:ans[0][i-1]+1;
    	}
    	
    	for(int i=1;i<row;i++){
    		if(matrix[i][0]==1)//处理第一列
    			ans[i][0] = ans[i-1][0]==MAX?MAX:ans[i-1][0]+1;
    		
    		for(int j=1;j<col;j++){
    			if(matrix[i][j]==1){
    				int temp = Math.min(ans[i-1][j],ans[i][j-1]);
    				ans[i][j] = temp==MAX?MAX:temp+1;
    			}
    		}
    	}
    	
//    	右下 到 左上
    	for(int i=col-2;i>=0;i--){//处理最后一行
    		if(matrix[row-1][i]==1){
    			int temp = ans[row-1][i+1]==MAX?MAX:ans[row-1][i+1]+1;
    			ans[row-1][i] = Math.min(ans[row-1][i], temp);
    		}
    	}
    	
    	
    	for(int i=row-2;i>=0;i--){
    		if(matrix[i][col-1]==1){//处理最后一列
    			int temp = ans[i+1][col-1]==MAX?MAX:ans[i+1][col-1]+1;
    			ans[i][col-1] = Math.min(ans[i][col-1], temp);
    		}
    		
    		for(int j=col-2;j>=0;j--){
    			if(matrix[i][j]==1){
    				int temp = Math.min(ans[i+1][j],ans[i][j+1]);
    				temp = temp==MAX?MAX:temp+1;
    				ans[i][j] = Math.min(ans[i][j], temp);
    						
    			}
    		}
    	}
    	
    	return ans;
	}
	
}

		 
		 
		