package jianzhioffer.linkedlist;

import java.util.Stack;

public class ex4 {
    /*
        两个链表的第一个公共结点

        输入两个链表，找出它们的第一个公共结点。
     */

    /**
     * 暴力循环。最好不用 O（m*n）
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=null){
            while(p2!=null){
                if(p1==p2){
                    return p1;
                }
                p2=p2.next;
            }
            p2=pHead2;
            p1=p1.next;
        }
        return p1;
    }

    /**
     * 点赞最高:但是没怎么看懂
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = (p1==null ? pHead2 : p1.next);
            p2 = (p2==null ? pHead1 : p2.next);
        }
        return p1;
    }


    /**
     * good思路清晰 简单易懂
     * 思路： 如果存在共同节点的话，那么从该节点，两个链表之后的元素都是相同的。
     *        也就是说两个链表从尾部往前到某个点，节点都是一样的。
     *        我们可以用两个栈分别来装这两条链表。一个一个比较出来的值。
     *        找到第一个相同的节点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {//把Head1放入stack1中
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {//把pHead2放入stack2中
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonListNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }

        return commonListNode;
    }









}
