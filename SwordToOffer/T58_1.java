package SwordToOffer;

public class T58_1 {

//	输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
//	例如输入字符串"I am a student. "，则输出"student. a am I"。

//	同T151
	
	
    public String reverseWords(String s) {
    	
    	String[] temp = s.split(" ");
    	StringBuilder sb = new StringBuilder();
    	for(int i=temp.length-1;i>=0;i--){
    		String ss = temp[i];
    		if(ss.length()>0){
    			sb.append(ss);
    			sb.append(" ");
    		}
    	}
    	if(sb.length()==0) return "";
    	sb.deleteCharAt(sb.length()-1);
    	return sb.toString();
    	
    }
    
}
