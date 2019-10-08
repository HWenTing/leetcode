package T_501_600;

public class T541 {

//	给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
//	如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

//	每2k反转前k个
    public String reverseStr(String s, int k) {
    	char[] chars = s.toCharArray();
    	int i;
    	for(i=k;i<=s.length();i+=2*k){
    		reverse(chars,i-k,i-1);
    	}
    	if(i-k<=s.length())
    		reverse(chars,i-k,s.length()-1);
    	
//    	StringBuffer sb = new StringBuffer();
//    	for(char c:chars)
//    		sb.append(c);
//    	return sb.toString();
    	return new String(chars);//比上边快很多。。。
    }

	private void reverse(char[] chars, int i, int i2) {
		char temp;
		while(i<i2){
			temp=chars[i];
			chars[i] = chars[i2];
			chars[i2] = temp;
			i++;
			i2--;
		}
	}
    
    
}
