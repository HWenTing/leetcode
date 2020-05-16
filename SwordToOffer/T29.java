package SwordToOffer;

public class T29 {

//	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
	
    public int[] spiralOrder(int[][] matrix) {
    	if(matrix.length==0 || matrix[0].length==0){
    		return new int[0];
    	}
    	int[] ans = new int[matrix.length*matrix[0].length];
    	int cnt=0;
    	
    	int up=0;
    	int down=matrix.length-1;
    	int left=0;
    	int right = matrix[0].length-1;
    	while(true){
    		for(int i=left;i<=right;i++) ans[cnt++] = matrix[up][i];
    		if(++up>down) break;
    		
    		for(int i=up;i<=down;i++) ans[cnt++] = matrix[i][right];
    		if(--right<left) break;
    		
    		for(int i=right;i>=left;i--) ans[cnt++] = matrix[down][i];
    		if(--down<up) break;
    		
    		for(int i=down;i>=up;i--) ans[cnt++] = matrix[i][left];
    		if(++left>right) break;
    	}
    	
    	return ans;
    	
    }
    
    
}



