package T_1_100;

public class T3 {
//	static public int lengthOfLongestSubstring(String s) {
//        int len = 0;
//        int pos = 0; 
//        int count=0;
//        for(int i =0;i<s.length();i++){
//        	if(check(s.substring(pos, i),s.charAt(i))>=0){//有重复的
//        		int temp  = check(s.substring(pos, i),s.charAt(i));
//        		len = ((i-pos)>len)?(i-pos):len;
//        		pos = pos+temp;
//        		count=i-pos+1;
//        	}else{
//        		count++;
//        	}
//        }
//        if(count>len) len = count;
//
//        return len;
//    }
//	static int check(String s,char c){
//		for(int i =0;i<s.length();i++){
//			if(s.charAt(i)==c)
//				return i+1;//有相同的字母返回位置
//		}
//		return -1;//没有相同的字母
//		
//	}
	
//	滑动窗口思想
//	...好坑啊。。没说只有26个字母，，，
//	击败了96%
    public int lengthOfLongestSubstring(String s) {
        int[] cnt=new int[256];
        
        int left = 0;
        int right = 0;
        int ans=0;
        while(right<s.length()){
        	ans = Math.max(ans, right-left);
        	cnt[s.charAt(right)]++;
        	while(cnt[s.charAt(right)]>1){//左端点右移
        		cnt[s.charAt(left)]--;
        		left++;
        	}
        	right++;//右移
        }
        return ans;
    }
    
	public static void main(String []args){
		T3 t = new T3(); 
		String s = " ";
		System.out.println(t.lengthOfLongestSubstring(s));
	}
}
