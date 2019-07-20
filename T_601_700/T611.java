package T_601_700;

import java.util.Arrays;

public class T611 {

    public int triangleNumber(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int l,r;
        for(int i=2;i<nums.length;i++){
        	l=0;
        	r=i-1;
        	while(l<r){
        		if(nums[l]+nums[r]>nums[i]){
        			ans+=r-l;
        			r--;
        		}else{
        			l++;
        		}
        	}
        }
        return ans;
    }
    
    public static void main(String[] args){
    	T611 t=new T611();
    	int [] a={2,2,3,4};
    	System.out.println(t.triangleNumber(a));;
    }
}
