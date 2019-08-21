package T_301_400;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T349 {

	
//	俩集合求交集呗,但是感觉速度会慢
//	速度击败40%，内存击败25%
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset1 = new HashSet<>();
        Set<Integer> hashset2 = new HashSet<>();
        for(int i:nums1)
        	hashset1.add(i);
        for(int i:nums2)
        	hashset2.add(i);
        
//        以下的写法会报错
//        使用iterator遍历集合的同时对集合进行修改就会出现java.util.ConcurrentModificationException异常
//        for(Integer i:hashset1){
//        	if(!hashset2.contains(i))
//        		hashset1.remove(i);
//        }

//        正确写法
        Iterator<Integer> iterator = hashset1.iterator();
        while(iterator.hasNext()){
        	Integer integer = iterator.next();
        	if(!hashset2.contains(integer))
        		iterator.remove();
        }
        
        
        int[] ans = new int[hashset1.size()];
        int pos=0;
        for(int i:hashset1){
        	ans[pos++]=i;
        }
        System.out.println(ans[0]);
        return ans;
    }
    public static void main(String[] args) {
    	T349 t =new T349();
    	int[] nums1 = new int[]{4,9,5};
    	int[] nums2 = new int[]{9,4,9,8,4};
    	
    	t.intersection(nums1, nums2);
    }
    
}
