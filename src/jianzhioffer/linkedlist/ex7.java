package jianzhioffer.linkedlist;

public class ex7 {
    /*
        合并两个排序的列表

        输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */

    /**
     * 自己想的
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
//        if(list1==null&&list2==null){
//            return null;
//        }其实多余了，下面两句包括了
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode result = new ListNode(-1);
        ListNode r = result;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                ListNode p = new ListNode(p1.val);
                result.next = p;
                p1 = p1.next;
            } else {
                ListNode p = new ListNode(p2.val);
                result.next = p;
                p2 = p2.next;
            }
            if (p1 == null) {
                result = result.next;//注意这句，只要往后加数据就要把result往后移
                result.next = p2;
                break;
            }
            if (p2 == null) {
                result = result.next;
                result.next = p1;
                break;
            }
            result = result.next;
        }
        return r.next;
    }

    /**
     * 递归版本要好好想想
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge2(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }
    /**
     * 非递归版本 和自己想的一个思想
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l3.next = l5;
        l1.next = l3;
        l4.next = l6;
        l2.next = l4;
        ex7 e = new ex7();
        ListNode r = e.Merge(l1, l2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }


    }
}
