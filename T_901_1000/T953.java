package T_901_1000;


public class T953 {

	
//	某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//	给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
    
//	自定义排序
	int[] orders ;
	public boolean isAlienSorted(String[] words, String order) {
		orders = new int[26];
        for(int i=0;i<order.length();i++){
        	orders[order.charAt(i)-'a']=i;
        }
        
        for(int i=1;i<words.length;i++){
        	if(compare(words[i-1],words[i])>0)
        		return false;
        }
        return true;
    }
	
	public int compare(String o1, String o2) {
		int s1p=0;
		int s2p=0;
		while(s1p<o1.length() && s2p<o2.length()){
			if(orders[o1.charAt(s1p)-'a']<orders[o2.charAt(s2p)-'a'])
				return -1;
			else if(orders[o1.charAt(s1p)-'a']>orders[o2.charAt(s2p)-'a'])
				return 1;
			else{
				s1p++;
				s2p++;
			}
		}
		return s1p==o1.length()?(s2p==o2.length()?0:-1):1;
	}
}
