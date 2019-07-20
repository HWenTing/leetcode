package T_701_800;

public class T733 {
//	dfs思想，较为简单，重要的是理解题意，只影响相邻的元素
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	if(image[sr][sc]==newColor)
    		return image;
    	
    	dfs(image,sr,sc,newColor,image[sr][sc]);
    	return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor,int original){
    	image[sr][sc]=newColor;
//    	down
        for(int i=sr+1;i<image.length;i++){
        	if(image[i][sc]==original){
        		dfs(image,i,sc,newColor,original);
        	}
        	break;
        }
//       up 
        for(int i=sr-1;i>=0;i--){
        	if(image[i][sc]==original){
        		dfs(image,i,sc,newColor,original);
        	}
        	break;
        }
        
//        right
        for(int i=sc+1;i<image[0].length;i++){
        	if(image[sr][i]==original){
        		dfs(image,sr,i,newColor,original);
        	}
        	break;
        }
        
//      left
      for(int i=sc-1;i>=0;i--){
      	if(image[sr][i]==original){
      		dfs(image,sr,i,newColor,original);
      	}
      	break;
      }
      
    }
    
    public static void main(String[] args){
    	T733 t =new T733();
    	int [][]image = new int[][]{
    		{1,1,1},
    		{1,1,0},
    		{1,0,1}
    	};
    	for(int i=0;i<image.length;i++){
    		for(int j=0;j<image[0].length;j++){
    			System.out.print(image[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	image = t.floodFill(image, 1, 1, 2);
    	for(int i=0;i<image.length;i++){
    		for(int j=0;j<image[0].length;j++){
    			System.out.print(image[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    }
}
