package T_1_100;

public class T26 {

    public static int removeDuplicates(int[] nums) {
        int pos=0;
        for(int num : nums){
        	if(num!=nums[pos]){
        		pos++;
        		nums[pos]=num;
        	}
        }
        return pos+1;
    }
    
    public static void main(String[] args){
    	int[] nums={1,1,2};
    	int len = removeDuplicates(nums);
    	
    	for (int i = 0; i < len; i++) {
    	    System.out.print(nums[i]+" ");
    	}
    }
}
