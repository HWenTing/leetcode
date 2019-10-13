package T1k_1_100;

public class T1013 {

//	划分成三部分，使每部分和相等
	
//	简单判断求和不会溢出，然后求出sum/3,然后双指针找左半部分和右半部分，中间部分不用管
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i:A)
        	sum+=i;
        
        int subsum = 0; 
        if(sum%3==0)
        	subsum = sum/3;
        else 
        	return false;
        
        int left = 0;
        int right=A.length-1;
        int sumleft=0;
        int sumright=0;
        
        while(right-left>=1){
        	if(sumleft!=subsum){
        		sumleft+=A[left];
        		left++;

        	}
        	
        	if(sumright!=subsum){
        		sumright+=A[right];
        		right--;
        	}
        	
        	if(sumleft==subsum && sumright==subsum)
        		return true;
        }
        return false;
    }
    
}
