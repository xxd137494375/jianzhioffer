package jianzhioffer.string;

public class ex1 {
    /**
     * 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值
     * （包括整数和小数）。例如，字符串"+100",
     * "5e2","-123","3.1416"和"-1E-16"都表示数值
     * 。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    /**
     * 通过正则表达式
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * @param str
     * @return
     */

    public boolean isNumeric(char[] str) {
        String string = new String(str);
        return string.matches("[\\+-]?[0-9]*(\\.([0-9]+)?)?([eE][\\+-]?[0-9]+)?");
    }


    /**
     * 方法2 ：剑指offer :注意 1.e2,.1e2这种的数也是可以被计算机识别的数字,但是.e2不可以。
     */


    private int index = 0;

    public boolean isNumeric1(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;  //保证最后一个字符是数字。

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }


    public static void main(String[] args) {
        ex1 a = new ex1();
        char [] s = {'.','1','e','2',' '};
        System.out.println(a.isNumeric(s));
        System.out.println(a.isNumeric1(s));
    }

}
