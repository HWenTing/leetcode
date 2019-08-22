package T_401_500;

import java.util.HashMap;

public class T454 {

	
//	给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0
		
//	用hash，前两个一组，后两个一组
//	哦豁，速度击败了90%
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ab=new HashMap<Integer,Integer>();
        
        for(int i:A){
        	for(int j:B){
        		ab.put(i+j, ab.getOrDefault(i+j,0)+1);
        	}
        }
        
        int ans=0;
        for(int i:C){
        	for(int j:D){
        		if(ab.containsKey(-i-j))
        			ans+=ab.getOrDefault(-i-j,0);
        	}
        }
        return ans;
    }
    
    
}
