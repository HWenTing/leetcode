package T_1_100;

public class T9 {
    public static boolean isPalindrome(int x) {
        String number = x+"";
        String rev = new StringBuilder(number).reverse().toString();
        return number.equals(rev);
        
    }
    
	public static void main(String []args){
		System.out.println(isPalindrome(-121));
	}
}
