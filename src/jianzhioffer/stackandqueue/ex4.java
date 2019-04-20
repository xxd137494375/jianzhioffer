package jianzhioffer.stackandqueue;
import java.util.*;
public class ex4 {
    /*
        栈的压入、弹出序列

        输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序
        列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例
        如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对
        应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
        （注意：这两个序列的长度是相等的）
     */


    //自己想的
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0){
            return true;
        }
        //      Solution e = new Solution();
        Stack<Integer> stack = new Stack<>();
        int num = popA[0];
        int index=0;
        for(;index<pushA.length;index++){
            if(pushA[index]==num){
                break;
            }
            stack.push(pushA[index]);
        }
        for(int i=0;i<popA.length&&!stack.isEmpty();i++){
            if(popA[i]==stack.peek()){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return IsPopOrder(Remove(pushA,num),Remove(popA,num));
        }
        else
        {
            return false;
        }

    }
    public int[] Remove(int [] A,int num){
        int [] result = new int [A.length-1];
        int i=0;
        for (int n : A){
            if (n!=num){
                result[i++]=n;
            }
        }
        return result;
    }

//    public boolean IsReverse(int [] A,int [] B){
//        int len =A.length;
//        if(len==0){
//            return true;
//        }
//        Stack<Integer> stack = new Stack<>();
//        for (int num :A){
//            stack.push(num);
//        }
//        for(int i=0;i<B.length;i++){
//            if(B[i]==stack.peek()){
//                stack.pop();
//            }
//        }
//        if(stack.isEmpty()){
//             return true;
//        }
//        else
//        {
//            return false;
//        }
//    }




    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        if(pushA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0,j=0;i<pushA.length;){
            stack.push(pushA[i++]);
            while (j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }



        public static void main(String[] args) {
        ex4 e = new ex4();
        int[] A={1,2,3,4,5};

        int [] B ={4,5,3,2,1};
        System.out.println(e.IsPopOrder(A,B));
//        A=e.Remove(A,4);
//        for(int n :A){
//            System.out.println(n);
//        }

    }

}
