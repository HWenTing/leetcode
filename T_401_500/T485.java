package T_401_500;

public class T485 {
	
    public int findMaxConsecutiveOnes(int[] nums) {
    	int ans=0;
    	int temp=0;
        for(int i:nums){
        	if(i==1)
        		temp++;
        	else{
        		ans = Math.max(ans, temp);
        		temp=0;
        	}
        		
        }
        	
        return Math.max(ans, temp);
    }
    
	public static void main(String[] args){
		
	}
}
