package T_601_700;

public class T686 {

//	给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
	
//	因为B要不然多霸占两个A，要不然霸占一个A
//	判断B是否为((len(B)-1)/len(A)+2)A的子串 || 判断B是否为((len(B)-1)/len(A)+1)A的子串
    public int repeatedStringMatch(String A, String B) {
    	int times = (B.length()-1)/A.length()+1;//减1是处理刚好B是A的两倍的情况
        StringBuffer newA = new StringBuffer();
        for(int i=0;i<times;i++){
        	newA.append(A);
        }
        
        String newA1 = newA.toString();
        if(issub(newA1,B))//newA.lastIndexOf(B) > -1 直接用StringBuffer的lastIndexOf速度会提升很多
        	return times;
        String newA2 = newA.append(A).toString();
        if(issub(newA2,B))
        	return times+1;
        return -1;
    }

//    判断是否为子串
	private boolean issub(String newA2, String b) {
		return newA2.contains(b);
	}
    
}
