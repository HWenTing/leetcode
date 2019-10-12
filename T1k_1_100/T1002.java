package T1k_1_100;

import java.util.LinkedList;
import java.util.List;

public class T1002 {

//	给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
//	你可以按任意顺序返回答案。

//	打表计数，求最小值
    public List<String> commonChars(String[] A) {
        int[] cnt = new int[26];

        for(char c:A[0].toCharArray()){
        	cnt[c-'a']++;
        }
        for(int i=1;i<A.length;i++){
            int[] temp = new int[26];
            for(char c:A[i].toCharArray()){
            	temp[c-'a']++;
            }
         
            for(int p=0;p<26;p++){
            	cnt[p] = Math.min(cnt[p], temp[p]);
            }
        }
        
        LinkedList<String> ans = new LinkedList<>();
        for(int p=0;p<26;p++){
        	for(int i=0;i<cnt[p];i++)
        		ans.add((char)('a'+p)+"");
        }
        return ans;
    }
    
}
