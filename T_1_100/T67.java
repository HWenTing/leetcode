package T_1_100;

public class T67 {

//	直接调用方法来作弊2333.。。。。。好像不行，会溢出，还是老老实实用进位做
//    public String addBinary(String a, String b) {
//        int inta = Integer.parseInt(a, 2);
//        int intb = Integer.parseInt(b, 2);
//        
//        int ans = inta+intb;
//        return Integer.toBinaryString(ans);
//    }
    
    public String addBinary(String a, String b) {
    	//先预处理，保证a的长度大于等于b
        int lena = a.length();
        int lenb = b.length();
        char []chara;char []charb;
        if(lena>lenb){
            chara = new StringBuilder(a).reverse().toString().toCharArray();
            charb = new StringBuilder(b).reverse().toString().toCharArray();
        }else{
            chara = new StringBuilder(b).reverse().toString().toCharArray();
            charb = new StringBuilder(a).reverse().toString().toCharArray();
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
        	switch(chara[pos]-'0'+temp-'0'+carry){
    		case 3:
    			carry=1;
    			ans[pos]='1';
    			break;
    		case 2:
    			carry=1;
    			ans[pos]='0';
    			break;
    		case 1:
    			carry=0;
    			ans[pos]='1';
    			break;
    		case 0:
    			carry=0;
    			ans[pos]='0';
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
		T67 t =new T67();
		System.out.println(t.addBinary("0", "0"));
	}

}
