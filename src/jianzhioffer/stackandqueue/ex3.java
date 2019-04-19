package jianzhioffer.stackandqueue;
import java.util.Arrays;
import java.util.Stack;

public class ex3 {
    /*
        包含min函数的栈

        定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */

    /**
     * 借用辅助栈存储min的大小，自定义了栈结构
     */
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];
    //题目中带有
    public void push(int node) {
        ensureCapacity(size+1);//对elements进行扩容，保证elements有空可存
        elements[size++] = node;//将node存入elements
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);//在push一下min
        }
        //    System.out.println(min+"");
    }

    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    //题目中带有
    public void pop() {
        Integer top = top();
        if(top != null){//栈不为空 ！empty（）  or  size>0
            elements[size-1] = (Integer) null;//令最后一个数字为空，即栈顶为空
        }
        size--;
        minStack.pop();//这个是调用了Stack的pop（），
        min = minStack.peek();
        //    System.out.println(min+"");
    }
    //题目中带有
    public int top() {//返回栈顶元素
        if(!empty()){//size!=0
            if(size-1>=0)//siez>=1
                return elements[size-1];
        }
        return (Integer) null;//size<=0，
    }
    public boolean empty(){//判断elements是否为空
        return size == 0;
    }
    //题目中带有
    public int min() {
        return min;
    }
}
