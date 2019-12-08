package T_401_500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class T451 {
    
//	给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
	
	//根据value排序
	public static  String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
        	map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
        	@Override
        	public int compare(Entry<Character,Integer> o1,
                    Entry<Character,Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character,Integer> mapping:list){ 
        	int i=mapping.getValue();
        	char c = mapping.getKey();
        	while(i>0){
        		sb.append(c);
        		i--;
        	}
        }
        return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}

}
