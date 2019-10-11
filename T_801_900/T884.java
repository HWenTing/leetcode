package T_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T884 {
//	给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//	如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//	返回所有不常用单词的列表。
//	您可以按任何顺序返回列表。

//	拼接字符串A+B，然后返回拼接后的字符串中只出现过一次的单词
	public String[] uncommonFromSentences(String A, String B) {
		//1.合并A，B放到一个字符串数组中
		String[] AB = (A+" "+B).split(" ");	
		//2.计算每个字符串出现的次数
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < AB.length; i++) {
		    map.put(AB[i], map.getOrDefault(AB[i], 0)+1);
		}
		//3.如果出现的次数为1，就是唯一的不常见单词
		List<String> list = new ArrayList<>();		
		for (String key:map.keySet()) {
		    if (map.get(key)==1) {
		        list.add(key);
		    }
		}
		String[] res  = new String[list.size()];
		return list.toArray(res);
	}
}
