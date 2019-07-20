package T_1_100;

public class T48 {

    public static void rotate(int[][] matrix) {
    	int n = matrix.length;
        int[] temp = new int[4];
        
        for(int i=0;i<n-1;i++){
        	for(int j=i;j<n-i-1;j++){
        		        		
        		temp[0] = matrix[i][j];
        		temp[1] = matrix[j][n-1-i];
        		temp[2] = matrix[n-1-i][n-1-j];
        		temp[3] = matrix[n-1-j][i];
            	
        		
        		matrix[i][j]=temp[3];
        		matrix[j][n-1-i]=temp[0];
        		matrix[n-1-i][n-1-j]=temp[1];
        		matrix[n-1-j][i]=temp[2];
        		
        		
        	}
        }
        
        print(matrix);
    }
    
    public static void print(int[][] matrix) {
    	int len = matrix.length;
    
        for(int i =0;i<len;i++){
        	for(int j=0;j<len;j++){
        		System.out.print(matrix[i][j]+" ");
        	}
        	System.out.println();
        }
    }
    
    public static void main(String[] args){
//    	int[][] candidates = {{15,13, 2, 5},
//    			  			{14, 3, 4, 1},
//    			  			{12, 6, 8, 9},
//    			  			{16, 7,10,11}};
    	
    	
    	int[][] candidates = {{1,2,3},
			{4,5,6},
			{7, 8, 9}};
    	
    	
    	rotate(candidates);
    }
}
/*
 * 
 * 00 0(n-1) (n-1)(n-1) (n-1)0
 * 01 1(n-1) (n-1)(n-1) (n-1)0
 * 02 2n n(n-2) (n-2)0
 * 11 1
 * 
 * 
 * 
 * 
 * /
 */