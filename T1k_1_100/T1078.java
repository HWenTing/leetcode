package T1k_1_100;

import java.util.LinkedList;

public class T1078 {

//	给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
//	对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

	
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        LinkedList<String> ans = new LinkedList<>();
        
        for(int i=2;i<words.length;i++){
        	if(words[i-2].equals(first) && words[i-1].equals(second))
        		ans.add(words[i]);
        }
        
        return ans.toArray(new String[ans.size()]);
    }
    
}
