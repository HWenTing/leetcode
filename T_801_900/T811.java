package T_801_900;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class T811 {

//	统计子域名访问次数
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        
        String[] pair;
        for(String s:cpdomains){
        	pair=s.split(" ");
        	int dopos=pair[1].indexOf(".");
        	map.put(pair[1], map.getOrDefault(pair[1], 0)+Integer.parseInt(pair[0]));
        	
        	while(dopos>=0){
        		pair[1]=pair[1].substring(dopos+1);
        		dopos=pair[1].indexOf(".");
        		map.put(pair[1], map.getOrDefault(pair[1], 0)+Integer.parseInt(pair[0]));
        	}
        }
        
        List<String> ans = new LinkedList<>();
        for(Entry<String,Integer> e: map.entrySet()){
        	ans.add(e.getValue()+" "+e.getKey());
        }
        return ans;
    }
    
}
