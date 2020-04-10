package SwordToOffer;

public class T11 {

//	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//	输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
//	例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

//	二分法
	
    public int minArray(int[] numbers) {
    	
    	int left = 0;
    	int right = numbers.length-1;
    	int mid ;
    	
    	while(right-left>1){//缩小区间
    		mid = left + (right-left)/2;//因为区间长度大于2.所以mid≠left≠right
    		if(numbers[mid] == numbers[right])
    			right--;
    		else if(numbers[mid] > numbers[right])//最小值在右半部分
    			left = mid;
    		else//最小值在左半部分
    			right = mid;
    	}
    
    	return Math.min(numbers[left], numbers[right]);
    	
    }
    
}
