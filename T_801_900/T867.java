package T_801_900;

public class T867 {

//	给定一个矩阵 A， 返回 A 的转置矩阵。
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[col][row];
        for(int i=0;i<col;i++){
        	for(int j=0;j<row;j++){
        		ans[i][j] = A[j][i];
        	}
        }
        return ans;
    }
    
}
