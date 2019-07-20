package T_1_100;

public class T1 {
	static int[] twoSum(int[] nums, int target) {
		int temp[]={0,0};
        for(int i =0;i<nums.length-1;i++){
        	for(int j = i+1;j<nums.length;j++){
        		if(nums[i]+nums[j]==target){	
        			temp[0] = i;
        			temp[1] = j;
        		}
        	}
        }
        return temp;
    }
	public static void main(String []args){
		int a[] = {1,2,3,4};
		System.out.println(twoSum(a,7)[0]);
		
	}
}
