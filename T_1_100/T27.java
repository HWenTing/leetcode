package T_1_100;

public class T27 {

    public static int removeElement(int[] nums, int val) {
        int pos=0;
        for(int num : nums){
        	if(num!=val){
        		
        		nums[pos]=num;
        		pos++;
        	}
        }
        return pos;
    
    }
    
    
    public static void main(String[] args){
    	int[] nums={3,3,3,3};
    	int len = removeElement(nums,3);
    	
    	for (int i = 0; i < len; i++) {
    	    System.out.print(nums[i]+" ");
    	}
    }
    
    
}
