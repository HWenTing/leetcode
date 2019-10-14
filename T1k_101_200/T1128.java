package T1k_101_200;

import java.util.HashMap;

public class T1128 {


//	哈希表
//    public int numEquivDominoPairs(int[][] dominoes) {
//        HashMap<Integer,Integer> map;
//        map = new HashMap<>();
//        int ans=0;
//        for(int[] domino:dominoes){
//        	int temp;
//        	if(domino[0]<domino[1])
//        		temp = domino[0]*100+domino[1];
//        	else
//        		temp = domino[1]*100+domino[0];
//        	int val = map.getOrDefault(temp, 0);
//        	ans+=val;
//        	map.put(temp,val+1);
//        }
//        return  ans;
//    }
	
//	因为给了范围，开个数组就行
    public int numEquivDominoPairs(int[][] dominoes) {
    	int[][] map = new int[10][10];
        int ans=0;
        for(int[] domino:dominoes){
        	if(domino[0]>domino[1]){
        		int temp = domino[1];
        		domino[1] = domino[0];
        		domino[0] = temp;
        	}
        	ans+=map[domino[0]][domino[1]];
        	map[domino[0]][domino[1]]++;
        }
        return  ans;
    }
    
    
}
