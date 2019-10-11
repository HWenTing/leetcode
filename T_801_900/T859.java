package T_801_900;

public class T859 {

	
//	给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
	
	
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())//长度不同返回false
        	return false;
        
        int  change=0;//字符串不等，但是经过一次交换可以相同
        char firstA=0;
        char firstB=0;
        int[] cnt = new int[27];
        boolean pair = false;//字符串相等，并且有重复字母
        for(int i=0;i<A.length();i++){
        	cnt[A.charAt(i)-'a']++;
        	if(cnt[A.charAt(i)-'a']==2)
        		pair=true;
        	
        	if(A.charAt(i)!=B.charAt(i)){
        		if(change==0){
        			firstA = A.charAt(i);
        			firstB = B.charAt(i);
        			change++;
        		}else if(change==1){
        			if(A.charAt(i)==firstB && B.charAt(i) ==firstA){
        				change++;
        			}else{
        				return false;
        			}
        		}else{
        			return false;
        		}
        	}
        }
        
        return change==2 || (change==0 && pair);
    }
    
}
