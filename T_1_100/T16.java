package T_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T16 {
    public static int threeSumClosest(int[] nums, int target) {
    	int ans = Math.abs(target-(nums[0]+nums[1]+nums[2]));
    	int t=(nums[0]+nums[1]+nums[2]);
    	Arrays.sort(nums);
    	int len = nums.length;
    	int a=0,b=0,c=0;
    	for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { 
 
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (target  == nums[i]+nums[l] + nums[r]) {

                        return target;
                    } else if (nums[i]+nums[l] + nums[r] <target) {
                    	if(Math.abs(target-nums[i]-nums[l] - nums[r])<ans){
                    		ans = Math.abs(target-nums[i]-nums[l] - nums[r]);
                    		t = nums[i]+nums[l] + nums[r];

                    	}
                        while (l < r && nums[l] == nums[l + 1]) l++;   
                        l++;
                    } else {
                    	if(Math.abs(target-nums[i]-nums[l] - nums[r])<ans){
                    		ans = Math.abs(target-nums[i]-nums[l] - nums[r]);
                    		t = nums[i]+nums[l] + nums[r];

                    	}
                    	
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return t;
    	
    }
    
	public static void main(String []args){
		int[] num={1,6,9,14,16,70};
		System.out.println(threeSumClosest(num,81));
	}
}
