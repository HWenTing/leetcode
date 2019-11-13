package T_1_100;

public class T59 {

//	给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
	
//	模拟螺旋过程，在边界处进行进行判断
//	也可以参考T54
    public int[][] generateMatrix(int n) {
        
    	int val = 1;
    	int[][] ans = new int[n][n];
    	
    	int col = 0;
    	int row = 0;
    	int maxcol = n-1;
    	int maxrow = n-1;
    	int mincol = 0;
    	int minrow = 0;
    	int coldirect = 1;
    	int rowdirect = 0;
    	while(val<=n*n){

    		ans[row][col]=val;
    		val++;
    		
    		if(coldirect==1 && col==maxcol){
    			coldirect=0;
    			rowdirect=1;
    			minrow++;
    		}else if(rowdirect==1 && row == maxrow){
    			coldirect=-1;
    			rowdirect=0;
    			maxcol--;
    		}else if(coldirect==-1 && col==mincol){
    			coldirect=0;
    			rowdirect=-1;
    			maxrow--;
    		}else if(rowdirect==-1 && row == minrow){
    			coldirect=1;
    			rowdirect=0;
    			mincol++;
    		}
    		row+=rowdirect;
    		col+=coldirect;
    	}
    	
    	return ans;
    }
    
}
