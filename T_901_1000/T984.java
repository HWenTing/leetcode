package T_901_1000;

public class T984 {

//	给定两个整数 A 和 B，返回任意字符串 S，要求满足：
//	S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
//	子串 'aaa' 没有出现在 S 中；
//	子串 'bbb' 没有出现在 S 中。
	

//	先把少的单个放，然后计算多少个两个的，插空放
    public String strWithout3a3b(int A, int B) {
    	String a = "a";
    	String a2 = "aa";
    	String b = "b";
    	if(A<B){
    		int temp = A;
    		A = B;
    		B = temp;
        	a = "b";
        	a2 = "bb";
        	b = "a";
    	}
    	
    	int twice = Math.max(0, A-B-1);
    	StringBuffer sb = new StringBuffer();
    	int totallen = A==B?2*B:2*B+1;
    	
    	for(int pos=0;pos<totallen;pos++){
    		if(pos%2==0){
    			if(pos/2<twice)
    				sb.append(a2);
    			else
    				sb.append(a);
    		}else{
    			sb.append(b);
    		}
    	}
    	return sb.toString();
    	
    }
    
}
