package T1k_101_200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T1200 {

//	给你个整数数组 arr，其中每个元素都 不相同。
//	请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
	
//	先排序，从前往后捋
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new LinkedList<>();
        int min=Integer.MAX_VALUE;
        LinkedList<Integer> temp;

        for(int i=1;i<arr.length;i++){
        	if(arr[i]-arr[i-1]<min){
        		ans.clear();
        		temp =  new LinkedList<>();temp.add(arr[i-1]);temp.add(arr[i]);
        		ans.add(temp);
        		min = arr[i]-arr[i-1];
        	}else if(arr[i]-arr[i-1]==min){
        		temp =  new LinkedList<>();temp.add(arr[i-1]);temp.add(arr[i]);
        		ans.add(temp);
        	}
        }
        return ans;
    }
    
}
