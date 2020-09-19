package T_301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T336 {

//	给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
//	只能想出暴力破解的方法  果然超时了 复杂度n*n*m
//    public List<List<Integer>> palindromePairs(String[] words) {
//    	List<List<Integer>> ans = new LinkedList<>();
//    	for(int i =0;i<words.length-1;i++){
//    		for(int j =i+1;j<words.length;j++){
//        		if(palindrome(words[i]+words[j])){
//        			ans.add(get(i,j));
//        			if(words[i].length() == words[j].length()){
//        				ans.add(get(j,i));
//        				continue;
//        			}
//        		}
//        		
//        		if(palindrome(words[j]+words[i])){
//        			ans.add(get(j,i));
//        		}
//        	}
//    	}
//    	
//    	return ans;
//    }
//    private List<Integer> get(int i,int j){
//    	LinkedList<Integer> cur = new LinkedList<Integer>();
//    	cur.add(i);cur.add(j);
//    	return cur;
//    }
//    
//    private boolean palindrome(String s){
//    	int left = 0;
//    	int right = s.length()-1;
//    	while(left<right){
//    		if(s.charAt(left++)!=s.charAt(right--))
//    			return false;
//    	}
//    	return true;
//    }
	
//	当判断s1+s2是否为回文时  假设len1>len2 那么 s1可以拆分为两个部分t1+t2  满足t1与s2倒序  t2是回文
//	对每一个字符串 分别判断前半部分和后半部分是否为回文 ， 并寻找另一部分的倒序
//	 复杂度n*n*m
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();//可以用hashmap 或者 字典树

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word: words) {//倒序
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }

    
}
