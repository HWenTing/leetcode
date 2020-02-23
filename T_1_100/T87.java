package T_1_100;

import java.util.HashMap;
import java.util.LinkedList;

public class T87 {

//	给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
//	在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
//	可以多次交换
//	给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
	
	
//	dp  dp[i][j][k] 表示s1的(i,i+k) 与 s2的(j,j+k)是否是扰乱字符串 第三维代表区间长度
	
	public boolean isScramble(String s1, String s2) {
		if(s1.length()!=s2.length() || (s1.length()==1 &&!s1.equals(s2))) return false;
    	if(s1.equals(s2)) return true;
    	
    	int len = s1.length();
    	boolean[][][] dp = new boolean[len][len][len+1];
    	
    	for(int i=0;i<len;i++)
    		for(int j=0;j<len;j++)//如果只有一个长度，那么直接比较是否相等即可
    			dp[i][j][1] = s1.charAt(i)==s2.charAt(j);
    			
    	
    	for(int k=2;k<=len;k++){//区间的长度 逐渐增大
    		for(int i=0;i<=len-k;i++){//s1
    			for(int j=0;j<=len-k;j++){//s2
    				for(int p=1;p<k;p++){//从区间中任意位置分成两部分，那么分两种情况
    					
    					if((dp[i][j][p] && dp[i+p][j+p][k-p])||   //s11与s21是扰乱字符串 并且s12与s22是扰乱字符串
    							(dp[i][j+k-p][p] && dp[i+p][j][k-p])){ //s11与s22是扰乱字符串 并且s12与s21是扰乱字符串
    						dp[i][j][k] = true;
    						break;
    					}
    					
    				}
    			}
    		}
    	}
    	
    	return dp[0][0][len];
		
	}

//	递归+hashmap存储  超时
//	private HashMap<String,LinkedList<String>> map;
//    public boolean isScramble(String s1, String s2) {
//    	if(s1.length()!=s2.length() || (s1.length()==1 &&!s1.equals(s2))) return false;
//    	if(s1.equals(s2)) return true;
//    	
//    	map = new HashMap<>();
//    	
//    	for(int i=1;i<s1.length();i++){
//    		
//    		LinkedList<String> l1 = maybe(s1.toCharArray(),0,i);
//    		LinkedList<String> l2 = maybe(s1.toCharArray(),i,s1.length());
//    		for(String st1:l1){
//    			for(String st2:l2){
//    				if(s2.equals(st1+st2) || s2.equals(st2+st1))
//    					return true;
//    			}
//    		}
//    	}
//    	return false;
//    }
//
//	private LinkedList<String> maybe(char[] charArray, int start, int end) {
//		System.out.println(start+" "+end);
//		if(map.containsKey(start+"#"+end))
//			return map.get(start+"#"+end);
//		
//		LinkedList<String> ret = new LinkedList<>();
//		if(end==start+1){
//			ret.add(charArray[start]+"");
//			return ret;
//		}
//		
//		for(int i=start+1;i<end;i++){
//			LinkedList<String> l1 = maybe(charArray,start,i);
//			LinkedList<String> l2 = maybe(charArray,i,end);
//			for(String st1:l1){
//    			for(String st2:l2){
//    				ret.add(st1+st2);
//    				ret.add(st2+st1);
//    			}
//    		}
//		}
//		map.put(start+"#"+end, ret);
//		return ret;
//	}
	
	public static void main(String[] args) {
		T87 t = new T87();
		
//		System.out.println(t.isScramble("abcdefghijklmn","efghijklmncadb"));
		System.out.println(t.isScramble("abcdefghijk","hiefgcadbjk"));
//		System.out.println(t.isScramble("abcde","caebd"));
		
	}
    
    
}
