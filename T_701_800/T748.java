package T_701_800;

import java.util.HashMap;

public class T748 {

//	寻找words中能够覆盖licensePlate中字母的最短最靠前的单词

//	思路就是 统计licensePlate字母出现的次数，然后统计words中每个字符串中字母出现的次数，比对相应位置
	public String shortestCompletingWord(String licensePlate, String[] words) {
		HashMap<Character,Integer> hash = new HashMap<>();
		
		for(char c:licensePlate.toLowerCase().toCharArray()){
			if(c>='a' && c<='z'){
				hash.put(c, hash.getOrDefault(c, 0)+1);
			}
		}
		
		String ans=null;
		for(String s:words){
			HashMap<Character,Integer> temp = new HashMap<>(hash);

			for(char c:s.toCharArray()){
				if(temp.containsKey(c)){
					int cnt=temp.get(c);
					if(cnt==1)
						temp.remove(c);
					else
						temp.put(c, cnt-1);
				}
			}
			if(temp.isEmpty() &&(ans==null || ans.length()>s.length())){
				ans=s;
			}
		}
		return ans;
    }
    
}
