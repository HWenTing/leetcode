package T_101_200;

import java.util.HashMap;

public class T149 {

//	给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
	
//	第一想法是遍历，先取两个点 然后遍历第三个点，看是否三点共线 复杂度O(n^3)
//	判断是否共线可以看斜率 不是整数会有精度问题，可以保存最简分数
//	还可以根据点斜式 对每一个点，看其他点与该点的斜率 用hashmap存 复杂度O(n^2)
//	时间击败38% 空间73% 
	
    public int maxPoints(int[][] points) {
        if(points.length<3)
        	return points.length;
        int ans = 0;
        
        for(int i=0;i<points.length;i++){
        	HashMap<String,Integer> map = new HashMap<>();
        	
        	int x = points[i][0];
        	int y = points[i][1];
        	int duplicate = 0;//记录重复的点
        	int curmax=0;//记录与当前点共线的最大点数
        	for(int j=i+1;j<points.length;j++){
            	int x2 = points[j][0];
            	int y2 = points[j][1];
        		if(x==x2 && y==y2){//重复点
        			duplicate++;
        			continue;
        		}
        		String key = "none";
        		if(x!=x2){//斜率存在
        			if(y==y2)//斜率为0
        				key = "zero";
        			else{
        				int gcd = gcd(y2-y,x2-x);
        				key = (y2-y)/gcd + "@" + (x2-x)/gcd;//key为最简分式
        			}
        		}
        		
    			int temp = map.getOrDefault(key, 0)+1;
    			map.put(key, temp);
    			curmax = Math.max(temp, curmax);
        	}
        	ans = Math.max(ans, curmax+duplicate+1);
        }
    	return ans;
    }
    
    private int gcd(int a,int b){
    	while(b!=0){
    		int temp = a%b;
    		a = b;
    		b = temp;
    	}
    	return a;
    }
    

}
