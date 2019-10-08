package T_601_700;

public class T661 {

//	平滑图片
	
    public int[][] imageSmoother(int[][] M) {
        int[][] ans=new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
        	for(int j=0;j<M[0].length;j++){
        		ans[i][j]=smoth(M,i,j);
        	}
        }
        return ans;
    }

	private int smoth(int[][] m, int i, int j) {
		int cnt=0;
		int sum=0;
		int[] direct=new int[]{-1,0,1};
		for(int y:direct){
			for(int x:direct){
				if(i+y>=0 && i+y<m.length && j+x>=0 && j+x<m[0].length){
					cnt++;
					sum+=m[i+y][j+x];
				}
			}
		}
		return sum/cnt;
	}
    
}
