package SwordToOffer;

public class T04 {

//	在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

	//右上角往左下角撸
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

    	if(matrix.length==0 || matrix[0].length==0) return false;
    	int ROW = matrix.length;
    	int COL = matrix[0].length;
    	
    	int row = 0;
    	int col = COL-1;
    	
    	while(row<ROW && col>=0){
    		if(matrix[row][col]==target) return true;
    		
    		if(matrix[row][col]<target)
    			row++;
    		else
    			col--;
    	}
    	
    	return false;
    	
    }
    
}
