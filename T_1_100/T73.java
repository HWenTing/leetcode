package T_1_100;

public class T73 {

//	给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//	原地算法要擅长利用所给的空间
//	利用数组的首行和首列来记录 0 值。从数组下标的 A[1][1] 开始遍历，两个布尔值记录首行首列是否需要置0
    public void setZeroes(int[][] matrix) {
    	if(matrix.length==0 || matrix[0].length==0)
    		return;
    	int col = matrix[0].length;
    	int row = matrix.length;
    	
    	boolean firstrow = false;//记录首行是否含有0
    	for(int j=0;j<col&&!firstrow;j++)
    		if(matrix[0][j]==0)
    			firstrow=true;
    	
    	boolean firstcol = false;//记录首列是否含有0
    	for(int i=0;i<row&&!firstcol;i++)
    		if(matrix[i][0]==0)
    			firstcol=true;
    	
    	for(int i=1;i<matrix.length;i++){//用第一行和第一列来标记含有0的情况
    		for(int j=1;j<matrix[0].length;j++){
    			if(matrix[i][j]==0){
    				matrix[i][0]=0;
    				matrix[0][j]=0;
    			}
    		}
    	}
//    	处理赋值
    	for(int j=1;j<col;j++){
    		if(matrix[0][j]==0){
    			for(int i=1;i<row;i++)
    				matrix[i][j]=0;
    		}
    	}
    	
    	for(int i=1;i<row;i++){
    		if(matrix[i][0]==0){
    			for(int j=1;j<col;j++)
    				matrix[i][j]=0;
    		}
    	}
    	
    	if(firstrow){
    		for(int j=0;j<col;j++)
    			matrix[0][j]=0;
    	}
    	
    	if(firstcol){
    		for(int i=0;i<row;i++)
    			matrix[i][0]=0;
    	}
    }
    
}
















