package T_401_500;

public class T443 {

//	给定一组字符，使用原地算法将其压缩。
//	压缩后的长度必须始终小于或等于原数组长度。
//	数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//	在完成原地修改输入数组后，返回数组的新长度。
	
    public int compress(char[] chars) {
    	if(chars.length<=1) return chars.length;
        int cnt;
        int ans=0;
        for(int i=0;i<chars.length;i++){

        	cnt=1;
        	while(i+1<chars.length && chars[i]==chars[i+1]){

                i++;
        		cnt++;
        	}
        	if(cnt==1){
        		chars[ans]=chars[i];
        		ans++;
        	}else{

        		chars[ans]=chars[i];
        		ans++;
        		
        		for(char c:(cnt+"").toCharArray()){
        			chars[ans]=c;
        			ans++;
        		}
        	}
        }
        return ans;
    }
}
