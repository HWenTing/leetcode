package T_201_300;


public class T300 {

	
    public int lengthOfLIS(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
        int n=nums.length;
        int []dp = new int[n];
        for(int i=0;i<n;i++){
        	dp[i]=1;
        	for(int j=i-1;j>=0;j--){
        		if(nums[i]>nums[j])
        			dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        }
        int max = 0;
        for(int i:dp){
        	max = Math.max(max, i);
        }
        return max;
    }
    
    
	public static void main(String[] args) {
		T300 t =new T300();
		System.out.println();
		System.out.println(t.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

	}
	
}
