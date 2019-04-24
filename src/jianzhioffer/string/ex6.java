package jianzhioffer.string;

public class ex6 {
    /*
        把字符串转换成整数

        将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
        但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的
        库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     */

    /**
     * 为啥想不到呢？
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        int n = str.length();
        int result = 0;
        int s=1;

        if(str.charAt(0) == '-') s = -1;
        for(int i = (str.charAt(0) ==  '-' || str.charAt(0) == '+') ? 1 : 0; i < n; ++i){
            if(!('0' <= str.charAt(i) && str.charAt(i) <= '9')) return 0;//不是一个数字
            result = (result << 1) + (result << 3) + (str.charAt(i) & 0xf);//res=res*10+str[i]-'0';位运算效率更高
            // 字符'0'到'9'的ascii值的低4个二进制位刚好就是0到9所以str[i]&0xf等于str[i]-'0'。 位运算会比乘法运算效率高那么一点点点点...
        }
        return result*s;


    }

    /**
     * 判断一个字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = " 111";
        System.out.println(s==s.trim());

    }
}
