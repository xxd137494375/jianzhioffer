package jianzhioffer.shu;
import java.util.*;
public class ex5 {
    /*
        从上往下打印二叉树  （层次遍历）

        从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode tem = q.remove();
            if(tem.left!=null){
                q.add(tem.left);
            }
            if(tem.right!=null){
                q.add(tem.right);
            }
            result.add(tem.val);

        }
        return result;
    }











    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
