package T_701_800;

public class T733 {
	
//	有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//	给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
//	为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
//	最后返回经过上色渲染后的图像。

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
