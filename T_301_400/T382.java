package T_301_400;

import java.util.Random;

public class T382 {
	
//	给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
//	如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
	
//	蓄水池抽样算法 给定一个数据流，长度N很大，且N在遍历完数据之前不可知，如何在只便利一遍O(n)的情况下，能够随机选取m个不同的元素。
//	思路是先取m个元素放到蓄水池中，当i>=m时，在[0,i]中取随机数d，若d在[0，m-1]中，则用该元素替换蓄水池中的第d个元素
    ListNode head;
	public T382(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	int cnt=1;
        int ans=head.val;
        ListNode next = head.next;
//        Random random = new Random();
        while(next!=null){
        	cnt++;
//        	int rand = random.nextInt(cnt);
        	int rand = (int)(Math.random()*cnt);
        	if(rand==0)
        		ans = next.val;
        	next = next.next;
        }
        return ans;
    }
    
}








