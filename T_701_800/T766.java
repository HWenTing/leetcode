package T_701_800;

public class T766 {

//	如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
//	给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

//遍历判断吧 可以一行一行读，下一行错一位
    public boolean isToeplitzMatrix(int[][] matrix) {
        int leny = matrix.length;
        int lenx = matrix[0].length;

        int x,y,cur;
    	for(int i=0;i<lenx-1;i++){//上三角
    		y=0;x=i;
    		cur = matrix[y][i];
    		while(++x<lenx && ++y<leny){
    			if(matrix[y][x] !=cur)
    				return false;
    		}
    	}
    	
    	for(int i=1;i<leny-1;i++){//下三角
    		x=0;y=i;
    		cur = matrix[i][0];
    		while(++y<leny && ++x<lenx){
    			if(matrix[y][x] !=cur)
    				return false;
    		}
    	}
    	return true;
    }
}
