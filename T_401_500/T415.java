package T_401_500;

public class T415 {

//	给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//	和67很像，修改仅为规则即可
    public String addStrings(String num1, String num2) {
        
    	//先预处理，保证a的长度大于等于b
        int lena = num1.length();
        int lenb = num2.length();
        char []chara;char []charb;
        if(lena>lenb){
            chara = new StringBuilder(num1).reverse().toString().toCharArray();
            charb = new StringBuilder(num2).reverse().toString().toCharArray();
        }else{
            chara = new StringBuilder(num2).reverse().toString().toCharArray();
            charb = new StringBuilder(num1).reverse().toString().toCharArray();
            int temp = lena;
            lena=lenb;
            lenb=temp;
        }

        int pos=0;
        
        char [] ans = new char[lena+1];
        		
        int carry=0;
        while(pos<lena){
        	int temp;
        	if(pos<lenb){
        		temp = charb[pos];
        	}else{
        		temp = '0';
        	}
        	switch((chara[pos]-'0'+temp-'0'+carry)/10){
    		case 0:
    			ans[pos]=(char) ('0'+(chara[pos]-'0'+temp-'0'+carry)%10);
    			carry=0;
    			break;
    		case 1:
    			ans[pos]=(char) ('0'+(chara[pos]-'0'+temp-'0'+carry)%10);
    			carry=1;
    			break;
    		}
        	pos++;
        }
        if(carry==1)
        	ans[lena]='1';
        else
        	ans[lena]='0';
        
        String ret = new StringBuffer(String.valueOf(ans)).reverse().toString();//使用String.valueOf()将字符数组转换成字符串
        if(ret.charAt(0)=='0')
        	ret = ret.substring(1,lena+1);
        
        return ret;
    }
    
	public static void main(String[] args) {
		T415 t =new T415();
		System.out.println(t.addStrings("0", "0"));
	}

}
