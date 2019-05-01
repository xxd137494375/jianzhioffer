package jianzhioffer.shu;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/114:26
 */
public class ex10 {
    /*  35 2500
        二叉搜索树与双向链表

        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
        要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode p = pRootOfTree;
        if(p==null||(p.left==null&&p.right==null)){
            return p;
        }
        Convert(p.left);
        if(p.left!=null) p.left.right=p;
        if(p.right!=null) p.right.left=p;
        Convert(p.right);
        return pRootOfTree;
    }
}
