package T_401_500;

import java.util.HashMap;

public class T447 {

//	哈希表对每个点，存储距离相等的点 c(n,2)=1+2+...n-1; 两个点位置可以互换，因此结果*2;
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Double,Integer> map = new HashMap<>();
        int ans=0;
        
        for(int i=0;i<points.length;i++){
        	map.clear();
        	for(int j=0;j<points.length;j++){
        		if(i!=j){
        			double dis = Math.pow(points[i][0]-points[j][0], 2)+Math.pow(points[i][1]-points[j][1], 2);
        			if(map.containsKey(dis)){
        				ans+=map.get(dis);
        				map.put(dis, map.get(dis)+1);
        			}else{
        				map.put(dis, 1);
        			}
        		}
        	}
        }
        return ans*2;
    }
    
}
