package T_501_600;

public class T504 {

//	10进制转换7进制 比较简单没啥可说的
	private long change(int num){
    	int shang = num;
    	int yu = num%7;
    	int pos = 1;
    	long ans=0;
    	while(shang!=0){
    		ans+=pos*yu;
    		pos*=10;
    		shang = shang/7;
    		yu = shang%7;
    	}
    	return ans;
    	
	}
    public String convertToBase7(int num) {
    	if(num==0)
    		return 0+"";
    	long ans;
    	if(num>0){
    		ans = change(num);
    	}else{
    		ans = -change(-num);
    	}
    	return ans+"";
    }
    
//    呃。。。Java 中 static String toString(int num, int radix) 可以将一个整数转换为 radix 进制表示的字符串。
//    public String convertToBase7(int num) { 
//    	return Integer.toString(num, 7); 
//    }
    
	public static void main(String[] args) {
		T504 t =new T504();
		System.out.println(t.change(100000000));
	}

}
