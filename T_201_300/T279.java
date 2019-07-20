package T_201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T279 {
	
	//bfs的方法
//    public int numSquares(int n) {
//        List<Integer> squares = getnum(n);
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(n);
//        int level=0;
//        boolean[] visited = new boolean[n+1];
//        while(!queue.isEmpty()){
//        	int size = queue.size();
//        	level++;
//        	while(size>0){
//        		size--;
//        		int cur = queue.poll();
//        		for(int i:squares){
//        			if(cur - i==0){
//        				return level;
//        			}else if(cur-i<0){
//        				break;
//        			}else{
//        				int next = cur-i;
//        				if(!visited[next]){
//        					visited[next]=true;
//        					queue.add(next);
//        				}
//        			}
//        		}
//        	}
//        }
//        return -1;
//    }
	
	//动态规划的方法  dp[i] = Math.min(dp[i], dp[i-sq]+1);
    public int numSquares(int n) {
        List<Integer> squares = getnum(n);
        int[] dp = new int[n+1];
        
        for(int i =1;i<n+1;i++){
        	dp[i]=Integer.MAX_VALUE;
        	for(int sq :squares){
        		if(sq>i)
        			break;
        		dp[i] = Math.min(dp[i], dp[i-sq]+1);
        	}
        }
        
        return dp[n];
        
    }
    

    
//    得到n以内的平方数
    private List<Integer> getnum(int n){
    	List<Integer> nums = new ArrayList<>();
    	int st = 1;
    	int diff = 3;
    	while(st<=n){
    		nums.add(st);
    		st+=diff;
    		diff+=2;
    	}
    	
    	return nums;
    }
    
    public static void main(String[] args){
    	T279 t = new T279();
    	System.out.println(t.numSquares(5));

    }
}
