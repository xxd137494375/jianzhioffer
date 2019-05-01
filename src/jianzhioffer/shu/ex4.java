package jianzhioffer.shu;
import java.util.*;

public class ex4 {
    /*
        重建二叉树

        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例
        如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    /**
     * 自己最简单的想法
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0&&in.length==0){
            return null;
        }
        TreeNode t = new TreeNode(0);
        int num = pre[0];
        int len = pre.length;
        int index=0;
        for(;index<in.length;index++){
            if(in[index]==num)break;
        }
        t.val=pre[0];
        int[] in1 = Arrays.copyOf(in,index);
        int[] pre1 = Arrays.copyOfRange(pre,1,(index+1));
        t.left=reConstructBinaryTree(pre1,in1);

        int[] in2 = Arrays.copyOfRange(in,(index+1),len);
        int[] pre2 = Arrays.copyOfRange(pre,(index+1),len);
        t.right=reConstructBinaryTree(pre2,in2);
        return t;
    }


    /**
     * good  还是原来的数组，只是改变系数，不会增加空间复杂度
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree1(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree1(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree1(pre,startPre+1,startPre+i-startIn,in,startIn,i-1); //i-starin是在计算当前节点左子树节点个数
                root.right=reConstructBinaryTree1(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;

    }

    public static void main(String[] args) {
        ex4 t = new ex4();
        t.reConstructBinaryTree1(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
    }





}
