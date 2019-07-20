package T_701_800;

public class T744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length-1;
        int mid;
        while(l<=h){
        	mid = l+(h-l)/2;
        	
        	if(letters[mid]<=target){
        		l = mid+1;	
        	}else{
        		h = mid-1;
        		
        	}
        	
        }
       return l<letters.length?letters[l]:letters[0];
  
    }
    public static void main(String []args){
    	T744 t = new T744();
    	char[] let = {'c','f','j'};
    	System.out.println(t.nextGreatestLetter(let, 'g'));;
    }
    
    
}
