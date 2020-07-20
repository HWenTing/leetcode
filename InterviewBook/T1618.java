package InterviewBook;

public class T1618 {

	
//	你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
//	例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
//	但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

	
//	枚举法， 枚举出a、b代表字符串长度的所有可能
    public boolean patternMatching(String pattern, String value) {
    	if(pattern.length()==0 &&value.length()==0) return true;
    	
    	int len = value.length();
    	int cnta = 0;
    	int cntb = 0;
    	 	
    	char[] values = value.toCharArray();
    	for(char c:pattern.toCharArray()){//统计出a和b出现的次数
    		if(c=='a')cnta++;
    		else cntb++;
    	}
    	
    	if(cnta==0||cntb==0){//处理只有一中字母构成的情况
    		if(pattern.length()==0 || len%(cnta+cntb)!=0) return false;
    		int epoch = len/(cnta+cntb);//算出每个a匹配的长度
    		
    		for(int i=epoch;i<len;i+=epoch){//依次判断
    			if(!equal(values,0,epoch,i,i+epoch))
    				return false;
    		}
    		return true;
    	}
    	

    	for(int i=0;i*cnta<=len;i++){
    		if((len-i*cnta)%cntb==0){//确保长度满足lena*cnta+lenb*cntb=len
    			int lena = i;
    			int lenb = (len-i*cnta)/cntb;
    			if(value.substring(0,lena).equals(value.substring(lena,lena+lenb))) continue;//a与b表示不同字符串
    			int astart = pattern.indexOf('a')*lenb;
    			int bstart = pattern.indexOf('b')*lena;
    			
    			int cnt = 0;
    			for(char c:pattern.toCharArray()){
    	    		if(c=='a'){
    	    			if(!equal(values,astart,astart+lena,cnt,cnt+lena))
    	    				break;
    	    			cnt+=lena;
    	    		}else{
    	    			if(!equal(values,bstart,bstart+lenb,cnt,cnt+lenb))
    	    				break;
    	    			cnt+=lenb;
    	    		}
    	    	}
    			if(cnt==len) return true;
    		}
    	}
    	return false;
    }
    
    private boolean equal(char[] values,int s1 ,int e1,int s2 ,int e2){//判断是否相等
    	if(e2==s2) return true;
    	while(s2<e2){
    		if(values[s1]!=values[s2]) return false;
    		s1++;s2++;
    	}
    	return true;
    }
    
    
    
    
    
    
}
