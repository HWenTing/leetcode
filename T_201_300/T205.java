package T_201_300;

public class T205 {

//	给定两个字符串 s 和 t，判断它们是否是同构的。
//	要注意不能映射到同一个字符，要一对一
	
//	temp中存储对应关系，若没有则添加，若存在就判断是否一致
//	速度很快，内存一般
    public boolean isIsomorphic(String s, String t) {
    	
    	int len1 = s.length();
    	int len2 = t.length();
    	if(len1!=len2)return false;
    	
    	char[] temp = new char[256];
    	boolean[] visit = new boolean[256];//确保1对1映射
    	
    	for(int i=0;i<len1;i++){
    		char c1 = s.charAt(i);
    		if(temp[c1]==0 &&!visit[t.charAt(i)] ){
    			temp[c1]=t.charAt(i);
    			visit[t.charAt(i)]=true;
    		}
    		else
    			if(temp[c1]!=t.charAt(i))
    				return false;
    	}
    	return true;
    }
   
	public static void main(String[] args){

		char[] temp = new char[26];
		System.out.println(temp[0]==0);
		System.out.println("12".charAt(0));
	}
  
}
