package T_301_400;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class T347 {

	
//	给定一个非空的整数数组，返回其中出现频率前 k 高的元素。算法的时间复杂度必须优于 O(n log n)
//	想不到啊，感觉最少也是nlogn，毕竟要排序吧
	
//	啊 原来是nlogk复杂度。。。
//	topk （前k大）用小根堆，维护堆大小不超过 k 即可。
//	每次压入堆前和堆顶元素比较，如果比堆顶元素还小，直接扔掉，否则压入堆。检查堆大小是否超过 k，如果超过，弹出堆顶。复杂度是 nlogk
//    求前 k 大，用小根堆，求前 k 小，用大根堆
	
	public List<Integer> topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int num : nums)
           map.put(num, map.getOrDefault(num, 0) + 1);
       
       PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){//学习用法
           public int compare(Integer a, Integer b){
               return map.get(a) - map.get(b);
           }
       });
       
       
       for (int key : map.keySet()){//把小根堆维持在k的size
           if (pq.size() < k)
               pq.add(key);
           else if (map.get(key) > map.get(pq.peek())){
               pq.remove();
               pq.add(key);
           }
       }
       
       List<Integer> res = new ArrayList<>();
       while (!pq.isEmpty())
           res.add(pq.remove());
       
       return res;
   }
    
}
