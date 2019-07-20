package T_1_100;

public class T12 {
    public static String intToRoman(int num) {
    	String[] gewei = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    	String[] shiwei = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    	String[] baiwei = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    	String[] qianwei = {"","M","MM","MMM"};
        int ge = num%10;
        num-=ge;
        num/=10;
        int shi = num%10;
        num-=shi;
        num/=10;
        int bai = num%10;
        num-=bai;
        num/=10;
        int qian = num%10;
        return qianwei[qian]+baiwei[bai]+shiwei[shi]+gewei[ge];
    }
    
	public static void main(String []args){
		
		System.out.println(intToRoman(1994));
	}
}
