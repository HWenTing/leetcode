package SwordToOffer;

import java.util.Arrays;
import java.util.LinkedList;

public class T38 {

//	输入一个字符串，打印出该字符串中字符的所有排列。
//	你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
	
//	全排列
//	可以用Hashset来去重，但是也可以在回溯的时候就不进入重复的入口
//	回溯 能够击败90% 一遍ac
	private LinkedList<String> ret;
    public String[] permutation(String s) {
    	ret = new LinkedList<>();
    	char[] word = s.toCharArray();
    	Arrays.sort(word);//先排序，方便去重
    	dfs(new StringBuilder(), new boolean[word.length],word);
    	
    	return (String[])ret.toArray(new String[0]);
    }
    
    private void dfs(StringBuilder sb,boolean[] visit,char[] word){
    	if(sb.length()==word.length-1){//对于最后一个元素特殊处理
    		int pos = 0;
    		while(visit[pos]) pos++;
    		sb.append(word[pos]);
    		ret.add(sb.toString());
    		sb.deleteCharAt(sb.length()-1);
    		return;
    	}
    	
    	char former = 1;//这里有隐形的bug，如果string存在(char)1就会出问题，不过这里问题不大
    	for(int i=0;i<word.length;i++){
    		if(!visit[i] && former!=word[i]){//如果在这一层便利过该char，再次进入则会重复，所以选择跳过
    			visit[i]=true;
    			sb.append(word[i]);
    			dfs(sb,visit,word);
    			sb.deleteCharAt(sb.length()-1);
    			visit[i]=false;
    			former=word[i];
    		}
    	}
    	
    }
    

}
