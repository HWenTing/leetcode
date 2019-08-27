package T_1001;

public class T1169 {

    public List<String> invalidTransactions(String[] transactions) {
        
    }
    
    
//	第一反应是hashmap
//	我先假设是时间顺序的
//    public List<String> invalidTransactions(String[] transactions) {
//    	Arrays.sort(transactions);
//    	
//    	HashMap<String,String[]>hashmap = new HashMap<>();
//    	List<String> ans = new LinkedList<>();
//    	
//    	for(int i=0;i<transactions.length;i++){
//    		String transaction = transactions[i];
//    		String[] split = transaction.split(",");
//    		
//    		if(Integer.parseInt(split[2])>1000){
//    			ans.add(transaction);
//    			continue;
//    		}
//    		
//    		if(!hashmap.containsKey(split[0])){
//    			
//    		}
//    	}
//    }
    
//    public List<String> invalidTransactions(String[] transactions) {
//    	Arrays.sort(transactions);
//    	List<String> ans = new LinkedList<>();
//    	
//    	for(int i=0;i<transactions.length;i++){
//    		String transaction = transactions[i];
//    		String[] split = transaction.split(",");
//    		
//    		if(Integer.parseInt(split[2])>1000){
//    			ans.add(transaction);
//    			continue;
//    		}
//    		
//    		if(!hashmap.containsKey(split[0])){
//    			
//    		}
//    	}
//    }
}
