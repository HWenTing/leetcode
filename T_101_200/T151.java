package T_101_200;

public class T151 {

//	给定一个字符串，逐个翻转字符串中的每个单词。
	
//	常规操作 调库
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
