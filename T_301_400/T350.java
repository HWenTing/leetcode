package T_301_400;

import java.util.Arrays;
import java.util.HashMap;

public class T350 {
	
//	hashmap很简单
//	击败64%
//    public int[] intersect(int[] nums1, int[] nums2) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for(int i = 0; i < nums1.length; i++)
//        	map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
//        
//        //再遍历第二个数组，将于map中找到的key放入list中
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        for(int j = 0; j < nums2.length; j++){
//            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
//                list.add(nums2[j]); //添加到list中
//                map.put(nums2[j], map.get(nums2[j]) - 1);
//            }
//        }
//        
//        //最后，将list中的值放入数组中
//        int count = list.size();
//        int[] aux = new int[count];
//        for(int i = 0; i < count; i++){
//            aux[i] = list.poll();
//        }
//        return aux;
//    }

//	将list省略掉
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums1.length; i++)
        	map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        
        int[] intersection = new int[nums1.length>nums2.length?nums2.length:nums1.length];
        int index = 0;
        //再遍历第二个数组，将于map中找到的key放入list中
        for(int j = 0; j < nums2.length; j++){
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
            	intersection[index++] = nums2[j];
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
    
    
}
