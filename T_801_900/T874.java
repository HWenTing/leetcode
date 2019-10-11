package T_801_900;

import java.util.HashSet;

public class T874 {
//	机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
//	-2：向左转 90 度
//	-1：向右转 90 度
//	1 <= x <= 9：向前移动 x 个单位长度
//	在网格上有一些格子被视为障碍物。
//	第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
//	如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
//	返回从原点到机器人的最大欧式距离的平方。
	
//	注意是过程中的最大距离。。。
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for(int[] ob:obstacles){
        	set.add(ob[0]+"#"+ob[1]);
        }
        
        int[][] directs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};//上左下右
        int dir=0;//初始方向
        int x=0;//初始位置
        int y=0;
        int ans=0;
  
        for(int command:commands){
        	if(command==-2){
        		dir = (dir+1)%4;
        	}else if(command==-1){
        		dir = (4+dir-1)%4;
        	}else{
        		int[] direct = directs[dir];
        		int newx = x+direct[0];
        		int newy = y+direct[1];
        		while(command>0){
        			command--;
        			if(set.contains(newx+"#"+newy)){
        				break;
        			}
        			x = newx;
        			y = newy;
        			newx = x+direct[0];
        			newy = y+direct[1];
         		}
        		ans = Math.max(ans, x*x+y*y);
        	}
        }
        
        return ans;
    }
	  
    
}
