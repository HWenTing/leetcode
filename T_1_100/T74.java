package T_1_100;

public class T74 {
//	编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//	每行中的整数从左到右按升序排列。
//	每行的第一个整数大于前一行的最后一个整数。

//	两种做法，第一种和T240一样，从右上角往左下角找，类似二叉搜索树，若当前值小于目标值，向下；若大于目标值，向左
//	击败了48.75%	的用户
//    public boolean searchMatrix(int[][] matrix, int target) {
//    	if(matrix.length==0) return false;
//        int row = 0;
//        int col = matrix[0].length-1;
//    	while(row<matrix.length && col>=0){
//    		if(matrix[row][col]==target)
//    			return true;
//    		else if(matrix[row][col]<target)
//    			row++;
//    		else 
//    			col--;
//    	}
//    	return false;
//    }
    
//	第二种 二分搜索
//	击败了	100.00%	的用户
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0 ||matrix[0].length==0 ) return false;
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int left = 0;
    	int right = row*col-1;

    	while(left<right){
    		int mid = left+(right-left)/2;
    		int mrow = mid/col;
    		int mcol = mid%col;
    		if(matrix[mrow][mcol]==target)
    			return true;
    		else if(matrix[mrow][mcol]<target)
    			left=mid+1;
    		else
    			right=mid;
    	}
    	return matrix[left/col][left%col]==target;
    }
    
}
