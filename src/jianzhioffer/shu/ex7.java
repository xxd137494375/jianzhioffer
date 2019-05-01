package jianzhioffer.shu;
import java.util.*;

public class ex7 {
    /*
        二叉树的深度

    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

     */

    /**
     * 非递归写法 层次遍历
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        int result=0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        layer.add(root);
        int start = 0, end = 1;
        while(!layer.isEmpty()){//这里不能写成layer!=null；因为只要layer被创建就一定layer！=null一定会成立。
            TreeNode cur = layer.remove();
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result++;
            }
        }
        return result;
    }


    /**
     * good
     * 递归写法，很简单
     * @param pRoot
     * @return
     */
    public int TreeDepth1(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepth1(pRoot.left);
        int right = TreeDepth1(pRoot.right);
        return Math.max(left, right) + 1;
    }













}
