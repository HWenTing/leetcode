package T_801_900;

import java.util.HashMap;
import java.util.HashSet;

public class T827 {

	
	private int len;
    public int largestIsland(int[][] grid) {
        
    	len = grid.length;
    	int[][] union = new int[len][len];

    	HashMap<Integer,Integer> map = new HashMap<>();
    	map.put(0,0);
    	
    	int count = 2;
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			if(grid[i][j]==1){
    				int size = countAndFill(count,i,j,grid);
    				map.put(count, size);
    				count++;
    			}
    		}
    	}
    	
    	int ans=0;
    	boolean allland=true;
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			
    			if(grid[i][j]==0){
    				allland=false;
    				
    				
    				
    			}
    			
    		}
    	}
    	
    	
    	
    	
    }
    
    private int countAndFill(int count,int i,int j,int[][] grid){
    	if(i<0 || j<0 || i>=len ||j>=len || grid[i][j]!=1) return 0;
    	grid[i][j]=count;
    	
    	return 1+countAndFill(count,i-1,j,grid)+countAndFill(count,i,j+1,grid)+
    			countAndFill(count,i+1,j,grid)+countAndFill(count,i,j-1,grid);
    }

    private int[][] directs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    private int neighbor(int i,int j,int[][] grid,HashMap<Integer,Integer> map){
    	HashSet<Integer> set = new HashSet<>();
    	int ans=0;
    	
    	for(int[] d:directs){
    		int temp = (valid(i+d[0],j+d[1])&&grid[i+d[0]][j+d[1]]>0)?map.get(grid[i+d[0]][j+d[1]]):0;
    		if(!set.contains(temp)){
    			set.add(temp);
    			ans+=map.get(key)
    		}
    	}
    
    	return ans;
    }
    
    private boolean valid(int i,int j){
    	return i>=0 && j>=0 && i<len && j<len;
    }
}
