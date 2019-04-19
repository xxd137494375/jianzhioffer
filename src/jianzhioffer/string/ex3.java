package jianzhioffer.string;

public class ex3 {
    /**
     * 正则表达式匹配
     *
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达
     * 式。模式中的字符'.'表示任意一个字符，而'*'表
     * 示它前面的字符可以出现任意次（包含0次）。 在本
     * 题中，匹配是指字符串的所有字符匹配整个模式。例
     * 如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */

    public boolean match(char[] str, char[] pattern)
    {
        StringBuffer sb1 = new StringBuffer(new String(str));
        StringBuffer sb2 = new StringBuffer(new String(pattern));

        int index = 0;
        while(index!=-1){
            index = sb2.indexOf(".",index);
            if(index!=-1){

                sb2.replace(index,index+1,"//.");
            }
            index+=3;
            if(index>sb2.length()){
                break;
            }
        }
        index = 0;
        while(index!=-1){
            index = sb2.indexOf("*",index);
            if(index!=-1){
                sb2.replace(index,index+1,"//*");
            }
            index+=3;
            if(index>sb2.length()){
                break;
            }
        }


        String str2 = sb2.toString();
        String str1 = sb1.toString();

        return str1.matches(str2);


    }


    /**
        good
     *
     * 当模式中的第二个字符不是“*”时：
     * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
     *
     * 而当模式中的第二个字符是“*”时：
     * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     * 1、模式后移2字符，相当于x*被忽略；           *匹配0次
     * 2、字符串后移1字符，模式后移2字符；          *匹配一次
     * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；   *匹配多次
     *
     * 这里需要注意的是：Java里，要时刻检验数组是否越界。
     */


    public class Solution {
        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null) {
                return false;
            }
            int strIndex = 0;
            int patternIndex = 0;
            return matchCore(str, strIndex, pattern, patternIndex);
        }

        public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
            //有效性检验：str到尾，pattern到尾，匹配成功
            if (strIndex == str.length && patternIndex == pattern.length) {
                return true;
            }
            //pattern先到尾，匹配失败
            if (strIndex != str.length && patternIndex == pattern.length) {
                return false;
            }
            //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                    return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                            || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                            || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
                } else {
                    return matchCore(str, strIndex, pattern, patternIndex + 2);//不匹配
                }
            }
            //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            /***
             * if(((str[strindex]==pattern[patternindex])&&(strindex!=str.length))||(pattern[patternindex]=='.'&&strindex!=str.length)){
             * 注意这里strindex!=str.length要放到前面，最后会有strindex=str.length再次调用函数，会产生数组越界，到处异常
             * 如果有数组的边界条件和别的条件相与，把数组的边界条件要放前面，
             */
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
            return false;
        }

    }
}
