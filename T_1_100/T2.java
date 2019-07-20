package T_1_100;
import java.math.BigInteger;

public class T2 {
/*
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger i1 = new BigInteger("1");
		BigInteger num1 = new BigInteger("0");
		BigInteger i2 = new BigInteger("1");
		BigInteger num2 = new BigInteger("0");
		while(l1!=null){
			
			num1= num1.add(i1.multiply(new BigInteger(l1.val+""))) ;
			l1=l1.next;
			i1 = i1.multiply(new BigInteger("10"));
		}
		System.out.println(num1);
		
		while(l2!=null){
			
			num2= num2.add(i2.multiply(new BigInteger(l2.val+""))) ;
			l2=l2.next;
			i2 = i2.multiply(new BigInteger("10"));
		}
		System.out.println(num2);

		BigInteger result = num1.add(num2);
		BigInteger current = result.mod(new BigInteger("10"));
		result = result.divide(new BigInteger("10"));
		ListNode re = new ListNode(current.intValue());
		ListNode retu = re;
	
		while(!result.equals(new BigInteger("0"))){
			current = result.mod(new BigInteger("10"));
			result = result.divide(new BigInteger("10"));
			ListNode currentNode = new ListNode(current.intValue());
			re.next = currentNode;
			re = currentNode;
		}
		return retu;
    }
*/
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p =l1,q=l2,curr = dummyHead;
		int carry = 0;
		while(q!=null || p!=null){
			int left = (p!=null)?p.val:0;
			int right = (q!=null)?q.val:0;
			int sum = left+right+carry;
			carry = sum/10;
			curr.next=new ListNode(sum%10);
			curr = curr.next;
			if(p!=null) p=p.next;
			if(q!=null) q = q.next;			
		}
		if(carry>0){
			curr.next = new ListNode(1);
		}
		return dummyHead.next;
	}
	
	
	
	
	
	public static void main(String []args){
		ListNode lis11  = new ListNode(9);
		
		ListNode lis20  = new ListNode(1);
		ListNode lis21  = new ListNode(9);
		ListNode lis22  = new ListNode(9);
		ListNode lis23  = new ListNode(9);		
		ListNode lis24  = new ListNode(9);
		ListNode lis25  = new ListNode(9);
		ListNode lis26  = new ListNode(9);
		ListNode lis27  = new ListNode(9);
		ListNode lis28  = new ListNode(9);
		ListNode lis29  = new ListNode(9);
		
		lis20.next = lis21;
		lis21.next = lis22;
		lis22.next = lis23;
		lis23.next = lis24;
		lis24.next = lis25;
		lis25.next = lis26;
		lis26.next = lis27;
		lis27.next = lis28;
		lis28.next = lis29;


		ListNode temp = addTwoNumbers(lis11,lis20);
		while(temp!=null){
			
			System.out.print(temp.val);
			temp = temp.next;
		}
//		BigInteger a1 = new BigInteger("9");
//		BigInteger a2 = new BigInteger("99999999991");
//		System.out.println(a1.add(a2));
	}
}
