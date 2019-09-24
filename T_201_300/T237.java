package T_201_300;

public class T237 {

	
//	只告诉你要删除的节点，删除此节点
	
//	将下一个节点的值赋给当前结点，然后跳过下一节点	
    public void deleteNode(ListNode node) {
        if(node.next==null)
        	node=null;
        else{
        	node.val=node.next.val;
        	node.next=node.next.next;
        }
    }
    
}
