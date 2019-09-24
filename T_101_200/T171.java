package T_101_200;

public class T171 {

//	给定一个Excel表格中的列名称，返回其相应的列序号。
	
    public int titleToNumber(String s) {
        
    	int ans=0;
    	for(int i=s.length()-1;i>=0;i--){
    		int temp = s.charAt(i)-'A'+1;
    		ans+=temp*Math.pow(26, s.length()-i-1);
    	}
    	return ans;
    }
}
