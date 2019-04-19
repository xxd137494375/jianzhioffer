package jianzhioffer.string;

public class ex2 {
    /**
     * 替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    /**
     * 用StringBuffer自带的方法
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        String s1 = "%20";
        String s2 =" ";
        int i =0 ;
        int index = 0;
        while(i<str.length()&&index!=-1){ //注意index!=-1
            index=str.indexOf(s2);
            if(index!=-1){    //注意index=-1即没有找到空格不会取代
                str.replace(index,index+1,s1);
            }
            i=index;
        }
        return str.toString();
    }

    /**
     * 用StringBuffer和String自带的方法 简单暴力
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}
