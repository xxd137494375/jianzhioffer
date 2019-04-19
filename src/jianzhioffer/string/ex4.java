package jianzhioffer.string;

public class ex4 {
    /*
    左旋转字符串

    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是
    用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环
    左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3
    位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */

    /**
     * 借用API的想法
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        int len=str.length();
        if(len==0){
            return "";
        }
        n=n%len;
        String s1 = str.substring(n);//先切后补
        String s2 = str.substring(0,n);
        return s1.concat(s2);//s1+s2
        /*  优化一下 先补后切
             String s1 = str.substring(0,n);
             str+=s1;
             return str.substring(n);
         */
    }


    /**
     * 无力吐槽你们的做法了，这种AC，你们觉得面试能过吗？这道题考的核心是应聘者是不是可以灵活利用字符串翻转。
     * 假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString1(String str, int n) {
        if (str == null || str.length() == 0) return "";
        char[] chars = str.toCharArray();
        if (n > chars.length) {
            n = n % chars.length;
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }



}
