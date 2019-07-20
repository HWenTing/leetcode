package T_101_200;

public class T153 {
    public int findMin(int[] nums) {
        int h = nums.length-1;
        int l = 0;
        int min = nums[h];
        while(l<h){
        	int mid = l+(h-l)/2;
        	
        	if(nums[mid]<min){
        		h=mid;
        	}else{
        		l=mid+1;
        	}
        	
        }
        return nums[l];
    }
    public static void main(String[] args){
    	T153 t = new T153();
    	int[] nums = {3,4,5,1,2};
    	System.out.println(t.findMin(nums));
    }
}
