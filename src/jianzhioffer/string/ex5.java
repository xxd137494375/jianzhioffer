package jianzhioffer.string;

import java.util.*;

public class ex5 {
    /*
        字符流中第一个不重复的字符

        请实现一个函数用来找出字符流中第一个只出现一次的字符。
        例如，当从字符流中只读出前两个字符"go"时，第一个只出
        现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

        如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    /**
     * 不会做啊
     *
     * 利用一个int型数组表示256个字符，这个数组初值置为-1.
     * 每读出一个字符，将该字符的位置存入字符对应数组下标中。
     * 若值为-1标识第一次读入，不为-1且》0表示不是第一次读入，将值改为-2.
     * 之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
     */
    //Insert one char from stringstream
    private int[] occurence = new int[256];
    private int index;

    public ex5(){//将int数组初值全部变为-1；
        for(int i=0;i<256;i++){
            occurence[i] = -1;
        }
        index = 0;
    }
    void Insert(char ch)
    {
        if(occurence[ch] == -1)//表示该字符第1次读入，将其为下标中数组的值变为》0的数
            occurence[ch] = index;//记录字符出现的顺序
        else if(occurence[ch] >= 0)//表示该字符不是第1次读入，设为-2
            occurence[ch] = -2;

        index++;//用于表示字符出现的顺序
    }
    //return the first appearence once char in current stringstream
    char FirstAppearingOnce()
    {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(occurence[i] >=0 && occurence[i]<minIndex){//找到只出现1次且值最小的，因为occurence存的是index表示字符的顺序
                ch = (char)i;
                minIndex = occurence[i];//该值出现的顺序
            }
        }
        if(ch == '\0')
            return '#';
        return ch;
    }

    }

