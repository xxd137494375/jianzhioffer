package jianzhioffer.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/4/3013:40
 */
public class ex7 {
    /*
        反转单词的顺序列

        牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
        写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向
        Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
        后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该
        是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */

    /**
     * 自己想的
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        String result = "";
        if(str.isEmpty()||str.length()==0||str.matches("\\s*")){ //str为空和只有空格的时候 str.trim()去除空格  str.trim()。equals("")；
            return str;
        }
        String[] array = str.split("\\s+");
        Stack<String> stack = new Stack<>();
        for(int i =0 ;i < array.length;i++){
            stack.push(array[i]);
        }
        for(int i=0;i<array.length;i++){
            result+=stack.pop()+" ";
        }
        result=result.substring(0,result.length()-1);
        return  result;
    }


    /**
     * 算法思想：先翻转整个句子，然后，依次翻转每个单词。
     * 依据空格来确定单词的起始和终止位置
     *
     * 收获：最字符串反转 1、可以先转成字符串数组，2、对数组进行反转，3、把数组转成字符串
     * @param str
     * @return
     */
    public String ReverseSentence1(String str) {
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);

    }
    //反转数组
    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
