package T_701_800;

import java.util.Arrays;
import java.util.HashSet;

public class T720 {
	
//	给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
//	若其中有多个可行的答案，则返回答案中字典序最小的单词。
//	若无答案，则返回空字符串。

//	题意实际上是，从一个字母开始，每次加在最后
	
//	先排序，然后用set判断是否在集合中
    public String longestWord(String[] words) {
    	Arrays.sort(words);
    	HashSet<String> set = new HashSet<>();
    	String ans="";
    	for(String s:words){
    		if(s.length()==1 || set.contains(s.substring(0, s.length()-1))){
    			set.add(s);
    			if(ans.length()<s.length())
    				ans=s;
    		}
    	}
    	return ans;
    }
    
//    不排序的方法
//    public String longestWord(String[] words) {
//        String result = "";
//        HashSet<String> strings = new HashSet<>();
//        Collections.addAll(strings, words);
//        for (String word : words) {
//            if ((word.length() > result.length() || word.length() == result.length() && word.compareTo(result) > 0) && isUsable(word, strings)) {
//                result = word;
//            }
//        }
//        return result;
//    }
//
//    private boolean isUsable(String word, HashSet<String> strings) {//判断是否合法
//        if (strings.contains(word)) {
//            if (word.length() == 1 || isUsable(word.substring(0, word.length() - 1), strings)) {
//                return true;
//            }
//            strings.remove(word);
//        }
//        return false;
//    }
}
