package T_201_300;

public class T240 {

//	编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
//	每行的元素从左到右升序排列。
//	每列的元素从上到下升序排列。


//	我的想法是，在一个正方形中，右下角元素最大，这样把目标封锁在右上角和左下角两个矩形里
//	然后递归
	
//    public boolean searchMatrix(int[][] matrix, int target) {
//    	if(matrix.length==0)return false;
//    	return find(matrix,0,0,matrix.length-1,matrix[0].length-1,target);
//    }
//    
//    private boolean find(int[][] matrix, int sr,int sc,int er,int ec,int target){
//    	System.out.println(sr+" "+sc+" "+er+" "+ec);
//    	if(sr>=matrix.length || er>=matrix.length || sc>=matrix[0].length || ec>=matrix[0].length || sr>er || sc>ec ){//判断不合理的
//    		return false;
//    	}
//    	
//    	if(sr==er && sc==ec){//逼近到一个点并且相等
//    		if(matrix[sr][sc]==target)
//    			return true;
//    		else
//    			return false;
//    	}
//    	
//    	int pre_sr=sr;
//    	int pre_sc=sc;
//    	while(sr<=er && sc<=ec){
//    		if(matrix[sr][sc]==target)
//    			return true;
//    		else if(matrix[sr][sc]<target){
//    			sr++;
//    			sc++;
//    		}else{
//    			break;
//    		}
//    	}
//    	return find(matrix,pre_sr,sc,sr-1,ec,target) || find(matrix,sr,pre_sc,er,sc-1,target);
//    }
	
//	妈耶。。。好像想复杂了很多
//	直接从右上角往左下逼近就好
    public boolean searchMatrix(int[][] matrix, int target) {
    	
    	if(matrix.length==0)return false;
    	int m = matrix.length, n = matrix[0].length; 
    	int row = 0, col = n - 1; 
    	while (row < m && col >= 0) { 
    		if (target == matrix[row][col]) 
    			return true; 
    		else if (target < matrix[row][col])
    			col--; 
    		else row++; 
    	}
    	return false;
    	
    }
	
	
}
