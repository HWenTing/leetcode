package T_601_700;

public class T696 {

//	给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
	
//	像统计有多少个回文子串那样，从某一位置向外扩张
//	啊。。竟然很慢。。
//	private int cnt=0;
//    public int countBinarySubstrings(String s) {
//    	for(int i=0;i<s.length()-1;i++){
//    		extendstring(s,i,i+1);
//    	}
//        return cnt;
//    }
//    
//    private void extendstring(String s,int start,int end){//扩张
//    	char l = s.charAt(start);
//    	char r = s.charAt(end);
//    	if(l==r)return;
//    	while(start>=0 && end<s.length() && s.charAt(start)==l && s.charAt(end)==r){
//    		cnt++;
//    		start--;
//    		end++;
//    	}
//    }
	
	
	
//	还有更简单的方法，因为只有0、1两个字符，只要在某处变了，取在变化处左边长度和右边长度的最小值就好
//	击败70%
    public int countBinarySubstrings(String s) {
        
    	int pre=0;
    	int change=0;
    	int ans=0;
    	char curval = s.charAt(0);
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)!=curval){//当前位置元素与前一个位置相同
    			curval = s.charAt(i);
    			ans+=Math.min(change-pre,i-change);//取在变化处左边长度和右边长度的最小值
    			pre = change;
    			change=i;//更改变化节点
    		}
    	}
    	ans+=Math.min(change-pre,s.length()-change);//在遍历结束时处理最后的转折
    	return ans;
    }
    
    public static void main(String[] args){
    	T696 t =new T696();
    	System.out.println(t.countBinarySubstrings("00110011"));
    }
    
    
}
