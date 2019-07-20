package T_1001;

import java.util.*;

public class T1005 {

    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int len = A.length;
        
        int ans = 0;
        int count=0;
        int changepos=len;
        
        for(int i=0;i<len;i++){
        	if(A[i]>=0){
        		changepos=i;
        	}
        }
        
        int i;
        for( i=0;i<K&&i<changepos;i++){
        	A[i] =-A[i];
        }
        

        
        if(i==K){
            for(int j=0;j<len;j++){
            	ans+=A[j];
            }
        	return ans; 
        }
        
        
     
        	
        	
        return 0;
        
    }
    
    public static void main(String[] args){
    	int[] aa = {3,-1,0,2};
    	System.out.println(largestSumAfterKNegations(aa,1));
    }
}
