package jianzhioffer.shu;
import java.util.*;
public class ex6 {
    /*
        按之字形顺序打印二叉树

        请实现一个函数按照之字形打印二叉树，即第一
        行按照从左到右的顺序打印，第二层按照从右至
        左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */

    /**
     * 自己想的，在层次遍历的基础上进行修改
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        if(pRoot==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        queue.add(pRoot);
        int i=1;
        int start =0;
        int end =1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            arraylist.add(temp.val);
            start++;
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(start == end ){
                start=0;
                end = queue.size();
                if(i%2==0){
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    while(!arraylist.isEmpty()){
                        a.add(arraylist.remove(arraylist.size()-1));
                    }
                    result.add(a);
                }
                if(i%2==1){
                    result.add(arraylist);
                }
                arraylist = new ArrayList<Integer>();
                i++;
            }
        }
        return result;

    }


    /**
        good  但是没有任何优化啊
     * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
     *  * 在海量数据时，这样效率太低了。
     *  * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
     *  * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
     *  *
     *  * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
     *  * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
     *  *     1)可用做队列,实现树的层次遍历
     *  *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
     * @param pRoot
     * @return
     */

    public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return ret;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
}}
