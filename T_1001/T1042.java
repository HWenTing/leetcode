package T_1001;

import java.util.HashMap;
import java.util.HashSet;

public class T1042 {

	
//	有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
//paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
//另外，没有花园有 3 条以上的路径可以进入或者离开。
//你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
//以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
    
	
	public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int[] ans = new int[N];//返回值
        for(int i=0;i<N;i++){
        	map.put(i+1, new HashSet<>());
        }
        for(int[] path:paths){//存放邻接矩阵
        	map.get(path[0]).add(path[1]);
        	map.get(path[1]).add(path[0]);
        }
        
        for(int i=1;i<=N;i++){
        	boolean[] used=new boolean[5];//1-4有哪些颜色被用了
        	for(int adj:map.get(i)){//第i个花园的邻接表
        		used[ans[adj-1]]=true;//标记用过的
        	}
        	
        	for(int color=1;color<5;color++){
        		if(!used[color]){//寻找没用过的
        			ans[i-1]=color;
        			break;
        		}
        	}
        }
        return ans;
     }
    
}
