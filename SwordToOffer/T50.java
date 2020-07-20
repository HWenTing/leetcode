package SwordToOffer;

public class T50 {

//	在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
	
//	遍历 先记录位置 然后找最小
    public char firstUniqChar(String s) {

    	int[] first = new int[26];
    	
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(first[c-'a']>0)
    			first[c-'a']=-1;
    		else if(first[c-'a']==0)
    			first[c-'a']=i+1;
    	}
    	

    	int index = Integer.MAX_VALUE;
    	for(int i:first){
    		if(i>0)
    			index = Math.min(index,i);
    	}
    	return index<Integer.MAX_VALUE?s.charAt(index-1):' ';
    }
    
}
