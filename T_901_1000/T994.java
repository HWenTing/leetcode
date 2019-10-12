package T_901_1000;

import java.util.LinkedList;
import java.util.Queue;

public class T994 {

	
//	在给定的网格中，每个单元格可以有以下三个值之一：
//	值 0 代表空单元格；
//	值 1 代表新鲜橘子；
//	值 2 代表腐烂的橘子。
//	每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
//	返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

//	bfs
	
	Queue<int[]> queue;
	int freshcnt;
    public int orangesRotting(int[][] grid) {
        queue = new LinkedList<>();
        freshcnt = 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]==1)
        			freshcnt++;
        		else if(grid[i][j]==2)
        			queue.add(new int[]{i,j});
        	}
        }
        int time = bfs(grid);
        if(freshcnt==0) return time;
        return -1;
    }
    
//    广度优先搜索
    private int  bfs(int[][] grid){
    	if(freshcnt==0 && queue.isEmpty()) return 0;
    	int[][] directs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    	int time=-1;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		while(size>0){
    			int[] temp = queue.poll();
    			for(int[] direct : directs){
    				int newi = direct[0]+temp[0];
    				int newj = direct[1]+temp[1];
    				if(newi>=0 && newi<grid.length && newj>=0 && newj<grid[0].length 
    						&&grid[newi][newj]==1 ){
    					freshcnt--;
    					grid[newi][newj]=2;
    					queue.add(new int[]{newi,newj});
    				}
    			}
    			size--;
    		}
    		time++;
    	}
    	return time;
    }
}
