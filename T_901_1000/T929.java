package T_901_1000;

import java.util.HashSet;

public class T929 {

	
	//字符串处理
    public int numUniqueEmails(String[] emails) {
    	HashSet<String> set = new HashSet<>();

    	for(String email:emails){
    		String[] splitat = email.split("@");
    		int index = splitat[0].indexOf('+');
    		StringBuffer sb = new StringBuffer();
    		if(index>=0){
    			sb.append(splitat[0].substring(0, index).replaceAll(".",""));//要特别注意，这里要加两个斜杠，否则.正则匹配数字
    		}else{
    			sb.append(splitat[0].replaceAll("\\.",""));
    		}
    		sb.append("@");//这个前后部分的分节符也不能少
    		sb.append(splitat[1]);
    		set.add(sb.toString());

    	}
    	return set.size();
    }
}
