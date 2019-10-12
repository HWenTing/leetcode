package T_901_1000;


public class T925 {

//	你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//	你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

    public boolean isLongPressedName(String name, String typed) {
    	if( name.length()>typed.length() || name.charAt(0)!=typed.charAt(0)) return false;
    	int p1 = 1;
    	int p2 = 1;
    	char before=name.charAt(0);
    	while(p1<name.length() && p2<typed.length()){
    		if(name.charAt(p1)==typed.charAt(p2)){
    			before=name.charAt(p1);
    			p1++;
    			p2++;
    		}else{
    			if(typed.charAt(p2)==before){
    				p2++;
    			}else{
    				return false;
    			}
    		}
    	}
    	if(p1<name.length()) return false;
    	for(;p2<typed.length();p2++){
    		if(typed.charAt(p2)!=before)
    			return false;
    	}
    	return true;
    }
    
}
