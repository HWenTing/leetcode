package T_701_800;

import java.util.Stack;

public class T735 {

//	给定一个整数数组 asteroids，表示在同一行的行星。
//	对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
//	找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

//	stack
	
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
        	int asteroid = asteroids[i];
        	
            if(st.isEmpty() || !(st.peek()>0 && asteroid<0))
            	st.add(asteroid);
            else{
            	if(asteroid+st.peek()==0)
            		st.pop();
            	else if(asteroid+st.peek()>0){
            		continue;
            	}else{
            		st.pop();
            		i--;
            	}
            }
        }

        
        int[] ans = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
        	ans[i] = st.pop();
        }
        return ans;
    }
    
}
