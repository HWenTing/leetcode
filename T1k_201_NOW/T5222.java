package T1k_201_NOW;

public class T5222 {

//	在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//	给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//	返回可以通过分割得到的平衡字符串的最大数量。


//	cnt计数，R+L- ，为0则断
	public int balancedStringSplit(String s) {
        int cnt=0;
        int ans=0;
        for(char c:s.toCharArray()){
        	if(c=='R')
        		cnt++;
        	else
        		cnt--;
        	if(cnt==0)
        		ans++;
        }
        return ans;
	}
    
}
