package T_501_600;

public class T506 {

//	以空间换时间 
    public String[] findRelativeRanks(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        	max = Math.max(max, nums[i]);
        
        int dp[] = new int[max+1];
        
        for(int i=0;i<nums.length;i++){
        	dp[nums[i]]=i+1;
        }
        
        String[] ans = new String[nums.length];
        
        for(int i=max,j=0;i>=0;i--){
        	if(dp[i]>0){
        		j++;
        		switch(j){
	        		case 1:
	        			ans[dp[i]-1] = "Gold Medal";
	        			break;
	        		case 2:
	        			ans[dp[i]-1] = "Silver Medal";
	        			break;
	        		case 3:
	        			ans[dp[i]-1] = "Bronze Medal";
	        			break;	
        			default:
        				ans[dp[i]-1] = j+"";
        		}
        	}
        }
        return ans;
    }
    
    public static void main(String []args){
    	T506 t =new T506();
    	for(String i :t.findRelativeRanks(new int[]{123123,11921,1,0,123})){
    		System.out.println(i);
    	}
    	
    }
}
