package T_401_500;

public class T409 {

//	给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
	
//	出现偶数次的+（出现奇数次的-1）+（如果有奇数次的则+1）
	
    public int longestPalindrome(String s) {
        int[] count = new int[58];//A-z总长度
        for(char c : s.toCharArray())
        	count[c-'A']++;
        
        int add=0;
        int ans=0;
        for(int i:count){
        	if(i%2==0)
        		ans+=i;
        	else{
        		add=1;
        		ans+=i-1;
        	}
        }
        return ans+add;
    }
    
    
	public static void main(String[] args){
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println('z'-'A');
	}
    
}
