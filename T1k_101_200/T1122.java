package T1k_101_200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class T1122 {

//	按照特殊的方式排序
//	使用Arrays.sort
//	HashMap<Integer,Integer> map ;
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        map = new HashMap<>();
//        for(int i=0;i<arr2.length;i++){
//        	map.put(arr2[i], i);
//        }
//        Integer[] temp = new Integer[arr1.length];
//        for(int i=0;i<arr1.length;i++)
//        	temp[i]=arr1[i];
//        Arrays.sort(temp,new Comparator<Integer>(){
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(map.containsKey(o1) && map.containsKey(o2)){
//					return map.get(o1)-map.get(o2);
//				}else if(map.containsKey(o1)){
//					return -1;
//				}else if(map.containsKey(o2)){
//					return 1;
//				}else{
//					return o1-o2;
//				}
//			}
//        });
//        for(int i=0;i<arr1.length;i++)
//        	arr1[i]=temp[i];
//        
//        return arr1;
//    }

//	因为这个也给了范围，可以用计数排序来做
//	击败100%
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] bucket = new int[1001];
		for(int i:arr1)
			bucket[i]++;
		int cnt=0;
		for(int i:arr2){
			while(bucket[i]>0){
				arr1[cnt]=i;
				cnt++;
				bucket[i]--;
			}
		}
		for(int i =1;i<1001;i++){
			while(bucket[i]>0){
				arr1[cnt]=i;
				cnt++;
				bucket[i]--;
			}
		}
		return arr1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
// 想写快排来着，没写出来	
//	HashMap<Integer,Integer> map ;
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        map = new HashMap<>();
//        for(int i=0;i<arr2.length;i++){
//        	map.put(arr2[i], i);
//        }
//        
//        quicksort(arr1,0,arr1.length-1);
//        return arr1;
//    }
//    
//    private void quicksort(int[] arr1,int low,int high) {
//    	if(low>=high) return;
//    	System.out.println(low+""+high);
//		int base = arr1[low];
//		int left = low+1;
//		int right = high;
//		
//		while(left<=right){
//			while(left<=right && lessthan(arr1[left],base)){
//				left++;
//			}
//			while(left<=right && lessthan(base,arr1[right])){
//				right--;
//			}
//			if(left<right){
//				swap(arr1,left,right);
//			}
//			left++;
//			right--;
//		}
//		swap(arr1,base,left);
//		quicksort(arr1,low,left-1);
//		quicksort(arr1,left+1,high);
//	}
//    
//    private void swap(int[] arr1,int left,int right){
//		int temp = arr1[left];
//		arr1[left] = arr1[right];
//		arr1[right] = temp;
//    }
//
//	private boolean lessthan(int o1,int o2){
//		if(map.containsKey(o1) && map.containsKey(o2)){
//			return map.get(o1)<map.get(o2);
//		}else if(map.containsKey(o1)){
//			return true;
//		}else if(map.containsKey(o2)){
//			return false;
//		}else{
//			return o1<o2;
//		}
//    }
}
