package T1k_1_100;

public class T1047 {

//	给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//	在 S 上反复执行重复项删除操作，直到无法继续删除。
//	在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

//	栈
    public String removeDuplicates(String S) {
    	StringBuffer sb = new  StringBuffer();
    	for(char c:S.toCharArray()){
    		if(sb.length()>0 && sb.charAt(sb.length()-1)==c)
    			sb.deleteCharAt(sb.length()-1);
    		else
    			sb.append(c);
    	}
    	return sb.toString();
    }
    
}
