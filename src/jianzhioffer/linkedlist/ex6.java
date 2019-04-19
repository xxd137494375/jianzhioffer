package jianzhioffer.linkedlist;

import java.util.Stack;

public class ex6 {
    /*
        链表中倒数第K个结点

        输入一个链表，输出该链表中倒数第k个结点。
     */

    /**
     * 自己想到用栈来解决。
     *
     * 缺点：借用了其他数据结构来解决
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        int length=0;
        while(head!=null){
            stack.push(head);
            head=head.next;
            length++;
        }
        if(k>length||k<=0||length==0){//要综合考虑所有的情况
            return null;
        }
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        ListNode result = stack.pop();
        return result;
    }


    /**
     *  good:不用借用其他的高级数据结构就可以实现功能
     *
     * 最佳代码：Java代码，通过校验。代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，
     * 然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的
     * 时候，第二个结点所在位置就是倒数第k个节点了。。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head,int k) {
            if(head==null||k<=0){
                return null;
            }
            ListNode pre=head;
            ListNode last=head;
            for(int i=1;i<k;i++){
                if(pre.next!=null){
                    pre=pre.next;
                }else{//此处判断出了k>length的情况
                    return null;
                }
            }
            while(pre.next!=null){
                pre = pre.next;
                last=last.next;
            }
            return last;
    }










    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
}
}
