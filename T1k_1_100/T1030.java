package T1k_1_100;

import java.util.LinkedList;
import java.util.Queue;

public class T1030 {

//	给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//			另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
//			返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

//	排序
//    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//    	int[][] ans = new int[R*C][2];
//    	int cnt=0;
//    	for(int i=0;i<R;i++)
//        	for(int j=0;j<C;j++)
//        		ans[cnt++]=new int[]{i,j};
//    	
//    	Arrays.sort(ans,new Comparator<int[]>(){
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				int temp1 = Math.abs(o1[0]-r0)+ Math.abs(o1[1]-c0);
//				int temp2 = Math.abs(o2[0]-r0)+ Math.abs(o2[1]-c0);
//				return temp1-temp2;
//			}
//    	});
//    	return ans;
//    }
    
//	bfs 复杂度n
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] ans = new int[R*C][2];
		boolean[][] marked = new boolean[R][C];
		int[][] directs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
		
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{r0,c0});
		marked[r0][c0]=true;
		
		while(!queue.isEmpty()){
			ans[cnt] = queue.poll();
			
			for(int[] d:directs){
				int r = ans[cnt][0]+d[0];
				int c = ans[cnt][1]+d[1];
				if(r<R && r>=0 && c<C && c>=0 && !marked[r][c]){
					queue.add(new int[]{r,c});
					marked[r][c] = true;
				}
			}
			cnt++;
		}
		return ans;
		
	}
	
	
}
