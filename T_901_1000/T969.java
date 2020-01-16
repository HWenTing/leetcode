package T_901_1000;

import java.util.LinkedList;
import java.util.List;

public class T969 {

/**
 * 3 2 4 1
 * 4 2 3 1
 * 1 3 2 4
 * 3 1 2 4
 * 2 1 3 4
 * 1 2 3 4
 */
//	给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
//	返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。

//	类似冒泡排序，交换两次将目前最大的放到末尾
    public List<Integer> pancakeSort(int[] A) {
        LinkedList<Integer> ans = new LinkedList<>();
        item(A.length-1,A,ans);
        return ans;
    }
    
//    end后为排好序的
    private void item(int end,int[] A,List<Integer> ans){
    	if(end==0)return;
    	int max = A[0];
    	int maxpos = 0;
    	for(int i=1;i<=end;i++){//找最大值及其位置
    		if(A[i]>=max){
    			max = A[i];
    			maxpos = i;
    		}
    	}
    	if(maxpos!=end){//最大值刚好位于end位置则不用管，继续排序前end-1个，否则通过两次交换将该元素放在end位置
    		ans.add(maxpos+1);
    		swap(A,maxpos);
    		ans.add(end+1);
    		swap(A,end);
    	}
    	item(end-1,A,ans);
    }

	private void swap(int[] a, int end) {//反转数组
		int start = 0;
		while(end>start){
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
    
}
