package T_401_500;

public class T498 {
//	给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
	
//	顺着来，每到边界改变方向
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0 ||matrix[0].length==0)
        	return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] ans = new int[row*col];
        int r = 0;
        int c = 0;
        boolean ur = true;
        for(int i=0;i<row*col;i++){
        	ans[i] = matrix[r][c];
        	if(ur){//向右上走
        		if(c==col-1){//到达右边界
        			r++;
        			ur=false;
        		}else if(r==0){
        			c++;
        			ur=false;
        		}else{
        			r--;
        			c++;
        		}
        	}else{//向左下走
        		if(r==row-1){//到达下边界
        			c++;
        			ur=true;
        		}else if(c==0){
        			r++;
        			ur=true;
        		}else{
        			r++;
        			c--;
        		}
        	}
        }
        return ans;
    }
    
}
