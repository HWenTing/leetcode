package T_401_500;

public class T458 {

	
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest/minutesToDie+1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(times));
    }
    
    public static void main(String[] args){
    	String[] candidates = {};
    	System.out.println(poorPigs(1000,15,60));
    }
    
    
}
