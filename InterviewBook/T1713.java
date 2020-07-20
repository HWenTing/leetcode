package InterviewBook;


public class T1713 {

//	哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
//	像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
//	在处理标点符号和大小写之前，你得先把它断成词语。
//	当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
//	假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

//	dp[i]表示到第i个字符未识别的最小字符数
    public int respace(String[] dictionary, String sentence) {
    	
    	int len = sentence.length();
    	int[] dp = new int[len+1];

    	for(int i=1;i<=len;i++){
    		dp[i] = dp[i-1]+1;
    		for(String s:dictionary){
    			if(i>=s.length() && s.equals(sentence.substring(i-s.length(),i))){
    				dp[i] = Math.min(dp[i], dp[i-s.length()]);
    			}
    		}
    	}
    	return dp[len];
    }
    
    
}
