package jianzhioffer.timeefficient;

public class ex2 {
    /*
            整数中1出现的次数。

            求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
            为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出
            现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题
            更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
     */

    /**
     * 最简单的递归方法，但是时间效率和空间效率都不好,无法通过
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n==0){
            return 0;
        }
        int num = 0;
        int temp = n;
        while(n!=0){
            if((n%10)==1) {
                num++;
            }
            n=n/10;
        }
        return num+NumberOf1Between1AndN_Solution(temp-1);
    }

    /**
     * 用循环可以通过，大大减少空间的复杂度，但是时间复杂度还是差不多
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution1(int n) {
            if(n==0){
                return 0;
            }
            int num = 0;
            int temp=n;
            int[] nums = new int[n];
            for(int i =n;i>0;i--){
                n=i;
                while(n!=0){
                    if((n%10)==1) {
                        num++;
                    }
                    n=n/10;
                }
                nums[i-1]=num;
                num=0;
            }
            for(int i=0;i<temp;i++){
                num+=nums[i];
            }
            return num;
    }


    /**
     *  good
     *
     * 主要思路：设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
     * 当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31），每一次都包含100个连续的点，即共有(a/10+1)*100个点的百位为1
     * 当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有a/10(最高两位0-30)次是包含100个连续点，当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，所有点加起来共有（a%10*100）+(b+1)，这些点百位对应为1
     * 当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
     * 综合以上三种情况，当百位对应0或>=2或1时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
     * 之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
     * @param n
     * @return
     */
    //收获:把一个按位分成两部分 比如从百位拆分， n/i是前面的部分 ， n%i是后面的部分
    public int NumberOf1Between1AndN_Solution2(int n) {
        int count=0;
        int  i=1;
        for(i=1;i<=n;i*=10)
        {
            //i表示当前分析的是哪一个数位
            int a = n/i,b = n%i;
            count+=(a+8)/10*i+(a%10==1?(b+1):0);
        }
        return count;
    }
    public static void main(String[] args) {
        ex2 e =new ex2();
        System.out.println(e.NumberOf1Between1AndN_Solution1(211111111));


//        System.out.println(1/10);
    }

}
