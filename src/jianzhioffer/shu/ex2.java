package jianzhioffer.shu;
import java.util.*;
public class ex2 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /*
        把二叉树打印成多行

        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    /**
     * 队列LinkedList完成层序遍历，用end记录每层结点数目
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){//这里不能写成layer!=null；因为只要layer被创建就一定layer！=null一定会成立。
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
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
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
