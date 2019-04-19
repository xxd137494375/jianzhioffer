public class test1 {


    public static void main(String[] args) {
//        A a1= new A();
//        a1.s = 1;
//        System.out.println(a1.getS());
//        A a2 = new A();
//        a2.s = 2;
//        System.out.println(a2.getS());
//        a1=a2;
//        System.out.println(a1.getS());
//        a2.s=3;
//        System.out.println(a1.getS());
//        int [] a = {1,2,3,4};
//        int len=a.length;
//        int [] b =a;
//        b[0]=3;
//        for(int i=0;i<len;i++){
//            System.out.println(a[i]);
//        }
        test1 t = new test1();
        int [] a ={1,2,3,4,5,6,7};
        t.reOrderArray(a);

    }
    public void reOrderArray(int [] array){
        int len = array.length;
        int [] a =new int[len];
        int index=0;
        for(int i=0;i<len;i++){
            if(array[i]%2==1){
                a[index]=array[i];
                index++;
            }
        }
        for(int i=0;i<len;i++){
            if(array[i]%2==0){
                a[index]=array[i];
                index++;
            }
        }
        array=a;
        for(int i=0;i<7;i++){
            System.out.println("array"+array[i]);
        }
    }
}
