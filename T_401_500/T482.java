package T_401_500;

public class T482 {

//	给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。
//	给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。
//	两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。

//	按部就班
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        int cnt=0;
        for(int i=S.length()-1;i>=0;i--){
        	if(S.charAt(i)!='-'){
        		sb.append(S.charAt(i));
        		cnt++;
        	}
        	if(cnt==K && i>0){
        		cnt=0;
        		sb.append('-');
        	}
        }
        if(sb.length()==0) return "";
        else if(sb.charAt(sb.length()-1)=='-')
        	sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString().toUpperCase();
    }
    
}
