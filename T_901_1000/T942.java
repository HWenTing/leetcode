package T_901_1000;

import java.util.LinkedList;

public class T942 {

//	给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
//			返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
//			如果 S[i] == "I"，那么 A[i] < A[i+1]
//			如果 S[i] == "D"，那么 A[i] > A[i+1]

//	先按I正着放数，再放在最后，再按D倒着放
//	第一次没想优化，比较复杂，击败5%
//    public int[] diStringMatch(String S) {
//        int n = S.length();
//        LinkedList<Integer> increase = new LinkedList<>();
//        LinkedList<Integer> decrease = new LinkedList<>();
//        int[] ans = new int[n+1];
//        for(int i=0;i<n;i++){
//        	char c = S.charAt(i);
//        	if(c=='I')
//        		increase.add(i);
//        	else
//        		decrease.add(i);
//        }
//        
//        int val=0;
//        for(int i:increase){
//        	ans[i]=val++;
//        }
//        ans[n]=val++;
//        for(int i=decrease.size()-1;i>=0;i--){
//        	ans[decrease.get(i)]=val++;
//        }
//        return ans;
//    }
    
	
//	其实遍历一遍就可以，击败95%
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] ans = new int[n+1];
        int valI=0;
        int valD=n;
        
        for(int i=0;i<n;i++){
        	char c = S.charAt(i);
        	if(c=='I')
        		ans[i]=valI++;
        	else
        		ans[i]=valD--;
        }
        
        ans[n]=valI;
        return ans;
    }
    
}
