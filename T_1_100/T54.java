package T_1_100;

import java.util.*;
public class T54 {

//	给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素
	
//	对于这种螺旋遍历的方法，重要的是要确定上下左右四条边的位置，
//	那么初始化的时候，上边up就是0，下边down就是m-1，左边left是0，右边right是n-1。
//	然后我们进行while循环，先遍历上边，将所有元素加入结果res，然后上边下移一位，如果此时上边大于下边，说明此时已经遍历完成了，直接break。
	
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	if(matrix.length==0){
    		return ans;
    	}
    	
    	int up=0;
    	int down=matrix.length-1;
    	int left=0;
    	int right = matrix[0].length-1;
    			
    	while(true){
    		for(int i=left;i<=right;i++) ans.add(matrix[up][i]);
    		if(++up>down) break;
    		
    		for(int i=up;i<=down;i++) ans.add(matrix[i][right]);
    		if(--right<left) break;
    		
    		for(int i=right;i>=left;i--) ans.add(matrix[down][i]);
    		if(--down<up) break;
    		
    		for(int i=down;i>=up;i--) ans.add(matrix[i][left]);
    		if(++left>right) break;
    	}
 
    	return ans;
    }
    
    public static void main(String[] args){
    	int[][] t={
    	           { 1, 2, 3, 4 },
    	           {5, 6, 7, 8},
    	           { 9,10,11,12 }
    				};
    	int[][] t2={
    			{2,3,4},
    			{5,6,7},
    			{8,9,10},
    			{11,12,13},
    			{14,15,16}
 				};
    	System.out.println(spiralOrder(t2));
    }
}

