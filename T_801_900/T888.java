package T_801_900;

import java.util.HashSet;

public class T888 {

//	交换A与B中的某个元素 使两数组和相等
	
//	先求两数组和，找出差值 ，结合set来做
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> setB = new HashSet<>();
        int sumA=0;
        int sumB=0;
        
        for(int i:A){
        	sumA+=i;
        }
        
        for(int i:B){
        	sumB+=i;
        	setB.add(i);
        }
        
        int diff = (sumA-sumB)/2;
        int[] ans = new int[2];
        for(int i:A){
        	if(setB.contains(i-diff)){
        		ans[0] = i;
        		ans[1] = i-diff;
        	}
        }
        return ans;
    }
    
}




