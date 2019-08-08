package T_501_600;

public class T566 {

//	模拟reshape函数
	
//	直接暴力遍历吧。。。速度还行，应该没啥别的方法
    public int[][] matrixReshape(int[][] nums, int r, int c) {
    	int row = nums.length;
    	int col = nums[0].length;
        if(row*col!=r*c)//不合理
        	return nums;
        
        int[][] ans = new int[r][c];
        int cnt=0;
        for(int i=0;i<r;i++){
        	for(int j=0;j<c;j++){
        		ans[i][j] = nums[cnt/col][cnt%col];//根据序号直接求得下标
        		cnt++;
        	}
        }
        return ans;
    }
    
}
