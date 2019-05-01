package jianzhioffer.shu;

import java.util.LinkedList;
import java.util.Queue;

public class ex8 {
    /*
        平衡二叉树

        输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */

    /**
     * 最直接的做法，遍历每个结点，借助一个获取树深度的递归函数，根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        int df = DepthOfShu(root.left)-DepthOfShu(root.right);
        if(Math.abs(df)>1){
            return false;
        }
        return  IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }


    public int DepthOfShu(TreeNode root){//求树的深度
        if(root==null)
            return 0;
        int left=DepthOfShu(root.left);
        int right=DepthOfShu(root.right);
        return (left>right?left:right)+1;
    }


    /**
     *
     *
     * 上面做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
     * 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二
     * 叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);//-1代表该树不是平衡二叉树
    }




}
