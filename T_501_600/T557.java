package T_501_600;

public class T557 {

//	给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

	
    public String reverseWords(String s) {
		String[] strs = s.split(" ");
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			buffer.append(new StringBuffer(strs[i]).reverse().toString());
			buffer.append(" ");
		}
		return buffer.toString().trim();
    }
    
//    public String reverseWords(String s) {
//        StringBuffer sb = new StringBuffer();
//        String[] S = s.split(" ");
//        for(String str:S){
//        	sb.append(reverse(str.toCharArray()));
//        	sb.append(" ");
//        }
//        sb.deleteCharAt(sb.length()-1);
//        return sb.toString();
//    }
//    
//	private String reverse(char[] chars) {
//		char temp;
//		int i=0;
//		int i2=chars.length-1;
//		while(i<i2){
//			temp=chars[i];
//			chars[i] = chars[i2];
//			chars[i2] = temp;
//			i++;
//			i2--;
//		}
//		return new String(chars);
//	}
	
}
