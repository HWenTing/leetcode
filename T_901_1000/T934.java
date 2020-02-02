package T_901_1000;

import java.util.LinkedList;
import java.util.Queue;

class Nodeij{
	int i,j;
	public Nodeij(int i,int j){
		this.i = i;
		this.j = j;
	}
}


public class T934 {

//	在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
//	现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
//	返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）

//// 想法是先dfs标注出一个岛屿，然后对一个岛屿的所有位置bfs找另一个岛屿的最短距离 复杂度mnmn
////	时间击败5%。。。 bfs的时候很耗时 
//	private int len;
//	private LinkedList<Nodeij> source;
//    public int shortestBridge(int[][] A) {
//        len = A.length;
//        source = new LinkedList<>();
//        
//        boolean stop=false;
//        for(int i=0;!stop && i<len;i++){
//        	for(int j=0;!stop &&j<len;j++){
//        		if(A[i][j]==1){
//        			countAndFill(2,i,j,A);
//        			stop=true;
//        		}
//        	}
//        }
//        
//        int ans=Integer.MAX_VALUE;
//	    for(Nodeij node:source){
//	    	ans = Math.min(ans, bfs(node,A));
//	    }
//        
//        return ans;
//    }
//    
//    private int[][] directs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//    private int bfs(Nodeij node, int[][] A) {
//    	boolean[][] marked = new boolean[len][len];
//    	Queue<Nodeij> queue = new LinkedList<>();
//    	queue.add(node);
//    	marked[node.i][node.j]=true;
//    	
//    	int ret=0;
//    	while(!queue.isEmpty()){
//    		int size = queue.size();
//    		ret++;
//    		
//    		for(int c=0;c<size;c++){
//    			node = queue.poll();
//    			for(int[] d:directs){
//    				int newi = node.i+d[0];
//    				int newj =  node.j+d[1];
//    				
//    				if(valid(newi,newj) && !marked[newi][newj]){
//    					if(A[newi][newj]==1) return ret-1;
//    					
//    					queue.add(new Nodeij(newi,newj));
//    					marked[newi][newj]=true;
//    				}
//    			}
//    		}
//    	}
//    	
//    	return 0;
//	}
//
//
//	private int countAndFill(int count,int i,int j,int[][] grid){
//    	if(i<0 || j<0 || i>=len ||j>=len || grid[i][j]!=1) return 0;
//    	grid[i][j]=count;
//    	source.add(new Nodeij(i,j));
//    	return 1+countAndFill(count,i-1,j,grid)+countAndFill(count,i,j+1,grid)+
//    			countAndFill(count,i+1,j,grid)+countAndFill(count,i,j-1,grid);
//    }
//    
////  判断坐标是否有效
//	private boolean valid(int i,int j){
//		return i>=0 && j>=0 && i<len && j<len;
//	}
	
	
//	相似的思路 dfs标记一个岛，记录下岛的四周的位置，从岛的海岸向外扩展，直到另一座岛 复杂度mn
//	击败87%
	private int len;
	private LinkedList<Nodeij> source;//存放一个岛的边缘
	
    
    public int shortestBridge(int[][] A) {
        if(A.length == 0) return -1;
        source = new LinkedList<>();
        len = A.length;
        firstLoop:
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j ++){
                if(A[i][j] == 1){
                	countAndFill(i, j, A);
                    break firstLoop;
                }
            }
        }
        
        
        while(true){
            if(source.isEmpty()) return -1;
            Nodeij edgePos = source.poll();
            int i = edgePos.i;
            int j = edgePos.j;
            
    		for(int[] d:directs){
    			int newi = i+d[0];
    			int newj = j+d[1];
    			if(!valid(newi,newj)) continue;
    			
                if(A[newi][newj] == 1) {
                    return A[i][j] - 1;
                }if(A[newi][newj] == 0){
                	A[newi][newj] = A[i][j] + 1;
                	source.add(new Nodeij(newi,newj));
                }
            }
        }
        
    }
    
    
    private int[][] directs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};  
	private void countAndFill(int i,int j,int[][] grid){
		if(!valid(i,j)) return ;
		grid[i][j]=-1;
		
		for(int[] d:directs){
			int newi = i+d[0];
			int newj = j+d[1];
			if(!valid(newi,newj)) continue;
			
			if(grid[newi][newj]==1) countAndFill(newi,newj,grid);
			else if(grid[newi][newj]==0){
				source.add(new Nodeij(newi,newj));
				grid[newi][newj]=2;
			}
		}
	}
	
//判断坐标是否有效
	private boolean valid(int i,int j){
		return i>=0 && j>=0 && i<len && j<len;
	}
	
	
}
    
    
    

