package jianzhioffer.linkedlist;
import java.util.ArrayList;
import java.util.Stack;
public class ex2 {
    /*
     * 从尾到头打印链表
     *
     *输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode==null){
            return new ArrayList();
        }
        ListNode listNode1=listNode;
        int i=0;
        ArrayList list = new ArrayList();
        while(listNode!=null){//计算有几个节点，保存在i中
            i++;
            listNode=listNode.next;
        }
        int[] num=new int[i];//创建一个数组
        i=0;

        while(listNode1!=null){
            num[i]=listNode1.val;
            listNode1=listNode1.next;
            i++;
        }
        for(i=num.length-1;i>=0;i--){
            list.add(num[i]);
        }
        return list;
    }


    /**
     * good  借用栈“后进先出”  ：看到后进先出优先想到栈
     */

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }


    /**
     * good 借助递归实现（递归的本质还是使用了堆栈结构）好好体会。
     * @param listNode
     * @return
     */

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();

        if(listNode!=null){

            list=printListFromTailToHead2(listNode.next);

            list.add(listNode.val);
        }

        return list;
    }
}
