package jianzhioffer.linkedlist;

public class ex1 {
    /*链表中环的入口结点
     *
     *  给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
     */
     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        if(pHead==null||pHead.next==null ){ //0个或1个节点不可能有环
            return null;
        }
        ListNode p1 = pHead.next;
        ListNode p2 = pHead.next.next;
        while(p1!=p2){
            if(p2.next!=null&&p2.next.next!=null){//走在前面的p2一直不为空，代表p2没到终点或者一直在环里转圈
                p1 = p1.next;
                p2 = p2.next.next;
            }
            else{//p2看到了终点，证明没有环
                return null;
            }
        }
        p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
