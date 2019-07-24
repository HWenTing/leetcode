package T_101_200;

public class T168 {
	
//	给定一个正整数，返回它在 Excel 表中相对应的列名称。
//	实质上是26进制
//    public String convertToTitle(int n) {
//    	if(n==0)
//		return 0+"";
//	
//		char []tochar = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//		StringBuffer sb = new StringBuffer();
//	   	int shang = n;
//		int  yu ;
//		while(shang!=0){
//			yu =shang%26;//这两步迭代的次数要注意
//			shang = shang/26;
//			
//			if(yu==0){//要特殊处理
//				yu = 26;
//				shang--;
//			}
//			sb.append(tochar[yu-1]);
//		}
//		return sb.reverse().toString();
//    }
    
//    递归方法。。。竟然击败了100%
    public String convertToTitle(int n) { 
    	if (n == 0)
    		return "";
    	n--; 
    	return convertToTitle(n / 26) + (char) (n % 26 + 'A'); 
    }
    
	public static void main(String[] args) {
		T168 t = new T168();
		System.out.println(t.convertToTitle(701));
	}

}
