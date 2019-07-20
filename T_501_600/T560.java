package T_501_600;
import java.util.ArrayList;

public class T560 {
	
////	从i位置 遍历向后的数组 复杂度为n^2
//	public static int subarraySum(int[] nums, int k) {
//		int count =0;
//		int length = nums.length;
//		int i;
//        for( i=0;i<length-1;i++){
//        	int temp=nums[i];
//        	if(temp == k) count++;
//        	for(int j=i+1;j<length;j++){
//        		temp+=nums[j];
//        		if(temp == k) count++;
//        	}
//        }
//        if(nums[i] == k) count++;
//        return count;
//    }
	
//	空间换时间 后缀和sum[i]为0-i的和
    public static int subarraySum(int[] nums, int k) {
        int len =nums.length;
        int []sum = new int[len];
        sum[0]=nums[0];
        for(int i=1;i<len;i++){
        	sum[i]=sum[i-1]+nums[i-1];
        }
        int ans=0;
        for(int i=0;i<len;i++){
        	for(int j=i;j<len;j++){
        		if(sum[j]-sum[i]+nums[j]==k){
        			ans++;
        		}

        	}
        }
        return ans;
    }
    
    
	public static void main(String [] args){
		int [] a = {1,1,1,1};
		System.out.println(subarraySum(a,2));
	}
}
