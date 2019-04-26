package jianzhioffer.array;
import  java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ex8 {
    /*
        把数组排成最小的数

        输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
        打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
        则打印出这三个数字能排成的最小数字为321323。
     */

    /**
     * 自己想的错误答案
     *
     * 自己想啊想。排序脑子里只有排序，怎么排？
     * 感觉是看每个数字的最高位排序，降序，然后
     * 其他位上再降序，其中考虑长度，想着想着做着越想越做越乱
     * @param numbers
     * @return
     */

    public String PrintMinNumber(int [] numbers) {

        int maxLen = 0;
        Map<String,Integer> map = new TreeMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int num :numbers){//把int转成String
            list.add(String.valueOf(num));
        }

        for(String s :list){//把字符串和长度存入map
            int n = s.length();
            if(n>maxLen){
                maxLen=n;
            }
            map.put(s,n);
        }

        Map<String,Integer> map1 = new TreeMap<>();
        for(String s :map.keySet()){//复制map到map1中，防止后面并发问题
            map1.put(s,map.get(s));
        }
        System.out.println(maxLen);
        System.out.println("变换前的map1");
        for (String s : map1.keySet()){
            System.out.println(s);
        }
        for(String s :map.keySet()){
            int len=map.get(s);
            if(len<maxLen){
                map1.remove(s);
                for(int i=len;i<maxLen;i++){
                    s=s+s.substring(len-1,len);
                    System.out.println("--"+s);
                }
                if(map1.get(s)==null){
                    map1.put(s,len);
                }else{
                    map1.put(s,len+map1.get(s));
                };
            }
        }
        System.out.println("变换后的map1");
        for (String s : map1.keySet()){
            System.out.println(s);
        }
        String result = "";
        for(String s :map1.keySet()){
            if(map1.get(s)>maxLen){
                result+=s.substring(0,map1.get(s)/2);
                result+=s.substring(0,map1.get(s)/2);

            }else{
                result+=s.substring(0,map1.get(s));
            }
        }
        return  result;
    }

    /**
     * star::比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。 ，突然大悟。
     *
     * 简单选择排序改编
     * @param numbers
     * @return
     */
    public String PrintMinNumber1(int [] numbers) {
        String str ="";
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(a>b){
                    int temp = numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        for(int i=0;i<numbers.length;i++){
            str+=String.valueOf(numbers[i]);
        }
        return str;
    }

    /**
     * 冒泡排序改变
     * @param numbers
     * @return
     */
    public String PrintMinNumber2(int [] numbers) {
        String str ="";
        boolean flag = true;
        for(int i=0;i<numbers.length&&flag;i++){
            flag=false;
            for(int j=numbers.length-2;j>0;j--){
                int a = Integer.valueOf(numbers[j]+""+numbers[j+1]);
                int b = Integer.valueOf(numbers[j+1]+""+numbers[j]);
                if(a>b){
                    flag=true;
                    int temp = numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        for(int i=0;i<numbers.length;i++){
            str+=String.valueOf(numbers[i]);
        }
        return str;
    }

    public static void main(String[] args) {
        int [] n = {321,32,3};
//        int [] n = {3,5,1,4,2};
//        int [] n = {111,11,1};
        ex8 e = new ex8();
        System.out.println("结果： "+e.PrintMinNumber1(n));
//        System.out.println("123".length());
    }
}
