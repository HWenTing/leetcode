package T_1_100;
import java.util.*;

public class T49 {

//	原来的思路好像就是一个一个比，速度很慢
//    public static List<List<String>> groupAnagrams(String[] strs) {
//    	List<List<String>> ans = new ArrayList<List<String>>();
//    	int len = strs.length;
//    	boolean[] checked=new boolean[len];
//    	for(int i =0;i<len ;i++){
//    		if(!checked[i]){
//	    		List<String> temp = new ArrayList<String>();
//	    		temp.add(strs[i]);
//	    		checked[i]=true;
//	    		for(int j=i;j<len;j++){
//	    			if(!checked[j]&&issame(strs[i],strs[j])){
//	    				temp.add(strs[j]);
//	    				checked[j]=true;
//	    			}
//	    		}
//	    		ans.add(temp);
//    		}
//    	}
//    	
//    	return ans;
//    }
//    public static boolean issame(String str1,String str2){
//    	int[] letter = new int[26];
//    	int len = str1.length();
//    	for(int i =0;i<len;i++){
//    		letter[str1.charAt(i)-'a']+=1;
//    	}
//    	
//    	len = str2.length();
//    	for(int i =0;i<len;i++){
//    		letter[str2.charAt(i)-'a']-=1;
//    	}
//    	
//    	for(int i : letter){
//    		if(i!=0){
//    			return false;
//    		}
//    	}
//    	return true;
//    	
//    }
    
//	先将每个字符串排序，然后hash
//	速度击败42%，最后返回值可以进一步优化
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return new ArrayList<>();
//        Map<String, List<String>> ans = new HashMap<String, List<String>>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
//    }
    
//	优化，地址传递，减少最后的赋值操作
//	速度击败90%，内存72%
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);//排序
            String key = String.valueOf(ca);
            if (!map.containsKey(key)){
            	//将map和ans中相同的list关联起来，同时修改。
            	List<String> temp = new ArrayList<>();
            	map.put(key,temp);
            	ans.add(temp);
            }
            map.get(key).add(s);
        }
        return ans;
    }

    
    
    
    
//    public static void main(String[] args){
//    	String[] candidates = {};
////    	System.out.println(issame("eat","tan"));
//    	System.out.println(groupAnagrams(candidates));
//    }
}
