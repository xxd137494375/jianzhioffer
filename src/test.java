import java.util.*;

public class test {
//    public static void main(String[] args) {
//         Integer[] elements = new Integer[10];
//
//        System.out.println(elements.length);
//        int[] A ={1,2,3,4,5};
//        int[] B= Arrays.copyOf(A,2);
//        for(int num:B){
//            System.out.println(num);
//        }
//        int[] C= Arrays.copyOfRange(A,1,6);
//        for(int num:C){
//            System.out.println(num);
//        }
//        String a = new String();
//        String b = "";
//        String c = null;
//        if(a.isEmpty())
//        {
//            System.out.println("String a = new String");
//        }
//        if(b.isEmpty())
//        {
//            System.out.println("String b = \"\"");
//        }
//        if(c==null)
//        {
//            System.out.println("String c =null");
//        }
//        if(null == a) {
//            System.out.println("String a =null");
//        }
//        if(a=="")
//        {
//            System.out.println("a = ''");
//        }
//        if(a == null){
//            System.out.println("1");
//        }
//        LinkedList q = null;
//        ((LinkedList) q).add(1);
//        System.out.println(q.remove());
//        if(q.isEmpty()){
//            System.out.println("q isempty");
//        }
//        if(q==null){
//            System.out.println("q==null");
//        }

    //    }
    public static void main(String[] args) {
//1
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数

            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.print(i+"----");
            for (int n :arr){
                System.out.print(n+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
