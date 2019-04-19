public class LinkedList implements Cloneable{
    int val;
    LinkedList next;

    public LinkedList(int val) {
        this.val = val;
    }



    public static void main(String[] args) {
        LinkedList l1= new LinkedList(1);
        LinkedList l2= new LinkedList(2);
        LinkedList l3= new LinkedList(3);
        LinkedList l4= new LinkedList(4);
        LinkedList l5= new LinkedList(5);
        LinkedList l6= new LinkedList(6);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        LinkedList p=l2;//l2.next=l3地址是一个常量赋给p
//        p.next=l5;
//        System.out.println(l3.next.val);//5
//        l3=l1;
////        System.out.println(p.val);//3
////        l2.next=l1;//把l1地址一个常量赋给l2.next
//        System.out.println(l2.next==l3);
//        System.out.println(p==l2.next);
//        System.out.println(p.val);
//        System.out.println(l2.next.val);
//        System.out.println("------------------");
//        LinkedList p = l2;
//        System.out.println(p.next.val);
//        p.next=l4;
//        System.out.println(l2.next.val);
//        System.out.println(p.next.val);
        System.out.println("------------");
        l2=l2.next.next;
        System.out.println(p==l2);
        System.out.println(p.val);
        System.out.println(l2.val);



    }
}
