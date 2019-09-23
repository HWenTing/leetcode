package T_101_200;

public class T125 {

	
//	给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//	说明：本题中，我们将空字符串定义为有效的回文串。
	
//	双指针向中间
//	小写字母和大写字母不是靠着的。。。中间隔了六个
    public boolean isPalindrome(String s) {
    	s = s.toUpperCase();
        int right = s.length()-1;
        int left=0;
        while(left<right){
        	
        	while(right>left && !check(s.charAt(right))){
        		right--;
        	}
        	
        	while(right>left &&!check(s.charAt(left))){
        		left++;
        	}

        	if(s.charAt(left++)!=s.charAt(right--))
        		return false;
        }
        return true;
    }
    
    private boolean check(char c){
    	if((c>='A' && c<='Z') || (c>='0' && c<='9'))
    		return true;
    	return false;
    }
    
}
