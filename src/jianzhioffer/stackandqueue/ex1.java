package jianzhioffer.stackandqueue;
import java.util.Stack;

public class ex1 {

    /**
     * 用两个栈实现队列：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 自己想得，通过画图。时
     * @param node
     */
    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {

        int result=0;
        while(!stack1.empty()){
            stack2.push(stack1.peek());
            stack1.pop();
        }
        result=stack2.peek();
        stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
        return result;
    }

    /**
     * 改进版  注意pop()和peek()都返回栈顶的值但是peek不出栈
     * @param node
     */
    public void push1(int node) {
        stack1.push(node);

    }

    public int pop1() {
        int result=0;
        if(stack1.empty()&&stack2.empty()){
            System.out.println("queue为空");//考虑特殊情况
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        result=stack2.pop();
        return result;
    }


}
