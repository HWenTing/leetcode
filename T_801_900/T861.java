package T_801_900;

public class T861 {

//	有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
//	移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
//	在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
//	返回尽可能高的分数。

	
//	贪心，有理由相信第一列必须是1，每一列1的个数大于0的个数
//	先通过每行的反转使第一列全为1，然后反转处理每一列，使每一列1的个数大于0的个数
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for(int i=0;i<row;i++){
        	if(A[i][0]==0){
        		for(int j=0;j<col;j++)
        			A[i][j] = A[i][j]^1;
        	}
        }
        int ans=(int) (Math.pow(2, col-1)*row);
        
        for(int j=1;j<col;j++){
        	int temp=0;
        	for(int i=0;i<row;i++)
        		if(A[i][j]==1)
        			temp++;

        	temp = Math.max(temp, row-temp);
        	ans+=Math.pow(2, col-j-1)*temp;
        }
        return ans;
    }
    
}
