package T_1_100;

public class T41 {

    public static int firstMissingPositive(int[] nums) {
        int len  = nums.length;
        int temp;
        int pos;
    	for(int i=0;i<len;i++){
    		if(nums[i]>0 && nums[i]<=len && nums[i]!=nums[nums[i]-1] ){
    			pos = nums[i]-1;
    			temp = nums[nums[i]-1];
    			nums[nums[i]-1]=nums[i];
    			nums[i]=temp;
    			if(i<pos){
    				i--;
    			}
    		}
    	}
    	
    	for(int i =0;i<len;i++){
    		if(nums[i]!=i+1){
    			return i+1;
    		}
    	}
    	return len+1;
    }
    
    public static void main(String[] args){
    	int[] candidates = {3,4,-1,1};
    	
    	System.out.println(firstMissingPositive(candidates));
    }
    
}
