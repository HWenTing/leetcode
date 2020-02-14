package T_501_600;

import java.util.HashMap;
import java.util.List;

public class T554 {

//	你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
//	砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
//	如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
//	你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

	
// hash表，记录每块砖右侧的位置，然后遍历位置，找到包含最多右侧位置的砖块	
    public int leastBricks(List<List<Integer>> wall) {
    	
    	int len = wall.size();
    	HashMap<Integer,Integer> map = new HashMap<>();
    	
    	int temp=0;
    	for(List<Integer> w:wall){
    		temp=0;
    		for(int i:w){
    			temp+=i;
    			map.put(temp, map.getOrDefault(temp, 0)+1);
    		}
    	}
    	map.remove(temp);
    	int max = 0;
    	for(int i:map.values())
    		max = Math.max(max, i);
    	return len-max;
    	
    }
    
    
}
