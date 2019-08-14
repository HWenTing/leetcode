package T_301_400;

public class T318 {

//	给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
	
//	我只想到了遍历一个一个判断
	
//	看了题解，发现也是要遍历的，终点在判断两个单词是否右相同的字母，可以用一个int来判断，节省空间速度也快
    public int maxProduct(String[] words) {
    	int len = words.length;
        int[] cha = new int[len];
        
        for(int i=0;i<len;i++){
        	String s = words[i];
        	for(char c:s.toCharArray())
        		cha[i] |= (1<<(c-'a'));//给每个位置赋值
        }
        
        int ans=0;
        for(int i=0;i<len;i++){
        	for(int j=0;j<len;j++){
        		if((cha[i]&cha[j])==0)//没有相同的字母，对应字母的位置均不相同
        			ans = Math.max(ans, words[i].length()*words[j].length());
        	}
        }
        return ans;
    }
}
