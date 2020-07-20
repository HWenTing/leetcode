package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T139 {

//	dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。该问题涉及到字典中单词的使用顺序，因此可理解
//	为涉及顺序的完全背包问题。
//	求解顺序的完全背包问题时，对物品的迭代应该放在最里层
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean []dp = new boolean[len+1];
        
        dp[0] = true;
        for(int i=0;i<=len;i++){
        	for(String str:wordDict){
        		if(i+str.length()<=len && str.equals(s.substring(i, i+str.length()))){
        			dp[i+str.length()]=dp[i] || dp[i+str.length()];
        		}
        	}
        }
        return dp[len];	
    }
//对上边的方法进行剪枝
    public boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        boolean []dp = new boolean[len+1];
        
        dp[0] = true;
        for(int i=0;i<=len;i++){
        	if(!dp[i]) continue;
        	
        	for(String str:wordDict){
        		if(i+str.length()<=len && str.equals(s.substring(i, i+str.length()))){
        			if(i+str.length()==len) return true;
        			dp[i+str.length()]=true;
        		}
        	}
        }
        return dp[len];	
    }
    
    
//  //输出dp矩阵
//    private  void printdp(boolean []dp){
//    	for(boolean i:dp){
//    		System.out.print(i+" ");
//    	}
//    	System.out.println();
//    }

    
	public static void main(String[] args) {
		T139 t = new T139();
		List<String> wordDict = new LinkedList<>();
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		
		System.out.println(t.wordBreak("catsandog", wordDict));
	}

    
}
