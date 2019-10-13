package T1k_1_100;

public class T1089 {

//	给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//	注意：请不要在超过该数组长度的位置写入元素。
//	要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

//	定义快慢指针，扫描两次数组。
//	第一次扫描定位复制结束的位置。首先初始化两个指针为 0，然后根据题意更新两个指针，直到快指针越过数组下标范围。
//	重置快慢指针位置，从后往前扫描，开始复制。

    public void duplicateZeros(int[] arr) {
        int left = 0;
        int right = 0;
        
        while(right<arr.length){
        	if(arr[left]==0) right++;
        	left++;
        	right++;
        }
        
        left--;
        right--;
        while(left>=0){
        	if (right < arr.length) arr[right]=arr[left];
        	if(arr[left]==0) arr[--right]=0;
        	left--;
        	right--;
        }
    }
    
}
