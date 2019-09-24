package T_301_400;

public class T345 {

//	编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

	public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int left=0;
        int right = ss.length-1;
        while(left<right){
        	while(left<right && !yuan(ss[left])){
        		left++;
        	}
        	
        	while(left<right && !yuan(ss[right])){
        		right--;
        	}
        	
        	if(left>=right)
        		break;
        	
        	char temp = ss[left];
        	ss[left] = ss[right];
        	ss[right]=temp;
        	
        	left++;
        	right--;
        }
        return String.copyValueOf(ss);
    }
    
    private boolean yuan(char a){
    	if(a=='a' ||a=='e' ||a=='i' ||a=='o' ||a=='u'
    			|| a=='A' ||a=='E' ||a=='I' ||a=='O' ||a=='U')
    		return true;
    	return false;
    }
}
