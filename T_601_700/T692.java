package T_601_700;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class T692 {
	
//	给一非空的单词列表，返回前 k 个出现次数最多的单词。
//	返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
	
//	求前k大，用最小堆
    public List<String> topKFrequent(String[] words, int k) {
     
    	HashMap<String ,Integer> map = new HashMap<>();
    	
    	for(String s:words){
    		map.put(s, map.getOrDefault(s, 0)+1);
    	}
    	PriorityQueue<Map.Entry<String,Integer>> heap = 
    			new PriorityQueue<Map.Entry<String,Integer>>(k,new Comparator<Map.Entry<String,Integer>>(){
					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {//比较大小的逻辑
						if(o1.getValue()==o2.getValue()){
							return -o1.getKey().compareTo(o2.getKey());
						}
						return o1.getValue()-o2.getValue();
					}
    			});
    	
    	int cnt=0;
    	for(Map.Entry<String,Integer> item:map.entrySet()){
    		if(cnt<k)
    			heap.add(item);
    		else{
    			if(item.getValue()>heap.peek().getValue() || 
    					(item.getValue()==heap.peek().getValue() &&item.getKey().compareTo(heap.peek().getKey())<0)){
    				heap.poll();
    				heap.add(item);
    			}
    		}
    		cnt++;
    	}
    	
    	List<String> ans = new ArrayList<>(k);
    	for(int i=0;i<k;i++)
    		ans.add(0, heap.poll().getKey());
    	
    	return ans;
    }
    
//    其实堆中的元素直接设置为string即可 对应的integer何以通过map得到
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> count = new HashMap();
//        for (String word: words) {
//            count.put(word, count.getOrDefault(word, 0) + 1);
//        }
//        PriorityQueue<String> heap = new PriorityQueue<String>(
//                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
//                w2.compareTo(w1) : count.get(w1) - count.get(w2) );
//
//        for (String word: count.keySet()) {
//            heap.offer(word);
//            if (heap.size() > k) heap.poll();
//        }
//
//        List<String> ans = new ArrayList();
//        while (!heap.isEmpty()) ans.add(heap.poll());
//        Collections.reverse(ans);
//        return ans;
//    }

}
