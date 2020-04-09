package SwordToOffer;

public class T05 {

//	请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    public String replaceSpace(String s) {
    	s.replace(" ","%20");
    	char[] chars = s.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for(char c:chars){
    		sb.append(c==' '?"%20":c);
    	}
    	return sb.toString();
    }
    
//    其实重点在于不利用额外空间，在原地修改 双指针
    public String replaceSpace(StringBuffer str) {
    	int len1 = str.length() - 1;
        for(int i = 0; i <= len1; i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int len2 = str.length() - 1;
        while(len2 > len1 && len1 >= 0){
            char c = str.charAt(len1--);
            if(c == ' '){
                str.setCharAt(len2--, '0');
                str.setCharAt(len2--, '2');
                str.setCharAt(len2--, '%');
            }else{
                str.setCharAt(len2--, c);
            }
        }
        return str.toString();
    }
    
}
