package T_401_500;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T407 {
//	有一种先上漫水的感觉，能漫到的地方之后肯定不会再增加。
	class node{
        int x;
        int y;
        int h;
        public node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<node> q = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.h -o2.h;
            }
        });

        if(heightMap.length < 3|| heightMap[0].length<3) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        int [][]dp = new int[row][col];
        //左右边界
        for (int i = 0; i < row; i++) {
            q.offer(new node(i,0,heightMap[i][0]));
            dp[i][0]=1;
            q.offer(new node(i,col-1,heightMap[i][col-1]));
            dp[i][col-1]=1;
        }
        //上下边界
        for (int i = 1; i < col-1; i++) {
            q.offer(new node(0,i,heightMap[0][i]));
            dp[0][i]=1;
            q.offer(new node(row-1,i,heightMap[row-1][i]));
            dp[row-1][i] = 1 ;
        }
        final int [][]dir = {{1,0},{0,-1},{0,1},{-1,0} };//右 左 上 下
        int res = 0;
        while(!q.isEmpty()){
            node t = q.poll();
            int x = t.x;
            int y = t.y;
            int h = t.h;
            for (int[] ints : dir) {
                int dx = x + ints[0];
                int dy = y + ints[1];
                if(dx <0 ||dx >= row || dy<0||dy>=col || dp[dx][dy]==1)
                    continue;
                if(h> heightMap[dx][dy]){

                    res+=h-heightMap[dx][dy];
                    heightMap[dx][dy] = h ;
                }
                q.add(new node(dx,dy,heightMap[dx][dy]));
                dp[dx][dy] =1;
            }
        }
        return res;

    }
    
    public static void main(String[] args){
    	int[][] ttt = { {1,4,3,1,3,2},
    			  		{3,2,1,3,2,4},
    			  		{2,3,3,2,3,1}};
    	T407 a = new T407();
    	a.trapRainWater(ttt);
    	
    }
    
    
    
}
