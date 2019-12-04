package T_1_100;

public class T82 {

//	给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//    递归
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        
        if(head.val!=head.next.val){//如果当前头节点是唯一的
        	head.next = deleteDuplicates(head.next);//头节点不变，递归next
        	return head;
        }
        	
//        否则跳过所有的重复节点
        int val = head.val;
        while(head!=null && head.val==val)
        	head = head.next;
        return deleteDuplicates(head);
        
    }
    
}
