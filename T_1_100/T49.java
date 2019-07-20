package T_1_100;
import java.util.*;

public class T49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> ans = new ArrayList<List<String>>();
    	int len = strs.length;
    	boolean[] checked=new boolean[len];
    	for(int i =0;i<len ;i++){
    		if(!checked[i]){
	    		List<String> temp = new ArrayList<String>();
	    		temp.add(strs[i]);
	    		checked[i]=true;
	    		for(int j=i;j<len;j++){
	    			if(!checked[j]&&issame(strs[i],strs[j])){
	    				temp.add(strs[j]);
	    				checked[j]=true;
	    			}
	    		}
	    		ans.add(temp);
    		}
    	}
    	
    	return ans;
    }
    public static boolean issame(String str1,String str2){
    	int[] letter = new int[26];
    	int len = str1.length();
    	for(int i =0;i<len;i++){
    		letter[str1.charAt(i)-'a']+=1;
    	}
    	
    	len = str2.length();
    	for(int i =0;i<len;i++){
    		letter[str2.charAt(i)-'a']-=1;
    	}
    	
    	for(int i : letter){
    		if(i!=0){
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    public static void main(String[] args){
    	String[] candidates = {};
//    	System.out.println(issame("eat","tan"));
    	System.out.println(groupAnagrams(candidates));
    }
}
