package T_501_600;

import java.util.Arrays;

public class T556 {

//	给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
	
//	123456
//	123465
//	123546
	
//	1234655
//	1234655
//	1235456
	
//	类似字典序
//	从右往左找到第一个比右侧小的数，然后找到该数右侧大于该数的最小的数交换位置，然后对右侧的数排序
	
//	转换成字符串有点慢
    public int nextGreaterElement(int n) {
    	char[] num = (n+"").toCharArray();
    	int index = num.length-2; 
    	for(;index>=0;index--){//找锚点
    		if(num[index]<num[index+1])
    			break;
    	}
    	if(index<0) return -1;
    	char anchor = num[index];
    	
    	for(int i=num.length-1;i>index;i--){//找交换点并交换
    		if(num[i]>anchor){
    			num[index] = num[i];
    			num[i] = anchor;
    			break;
    		}
    	}
    	
    	Arrays.sort(num,index+1,num.length);//排序后续节点 这里其实可以优化，可以直接反转，因为这里已经确保是倒叙的了
    	String nums = new String(num);
    	if(Long.parseLong(nums)>Integer.MAX_VALUE)
    		return -1;
    	else
    		return Integer.parseInt(nums);
    }
    
}
