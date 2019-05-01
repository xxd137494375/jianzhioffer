package jianzhioffer.shu;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/114:26
 */
public class ex10 {
    /*  20 703
        二叉搜索树与双向链表

        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
        要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */


    /**
     * 类似二叉树的线索化
     * @param pRootOfTree
     * @return
     */
    TreeNode pre=null;//定位前面的那个结点
    TreeNode headoftree=null;//定位最左边的结点  不能放到方法内，那样递归的时候就重置了，无法记住
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left=pre;
        if(pre!=null)pre.right=pRootOfTree;//第一次不执行
        pre=pRootOfTree;
        Convert(pRootOfTree.right);
        headoftree=headoftree==null?pRootOfTree:headoftree;//只有最左边那个节点回执行，得到最左边的那个结点
        return headoftree;
        //return FindHead(pRootOfTree);
    }

    //找到最左边的结点结点，可以代替上边那个三元
    TreeNode FindHead(TreeNode pRootOfTree){
        TreeNode p = pRootOfTree;
        TreeNode head = new TreeNode(0);
        if(pRootOfTree.left==null){
            head = pRootOfTree;
        }
        while(p!=null&&p.left!=null){
            head = p.left;
            p=p.left;
        }
        return head;
    }


    /**
     * 方法二：递归版
     * 解题思路：
     * 1.将左子树构造成双链表，并返回链表头节点。
     * 2.定位至左子树双链表最后一个节点。
     * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     * 4.将右子树构造成双链表，并返回链表头节点。
     * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     * 6.根据左子树链表是否为空确定返回的节点。
     * @param root
     * @return
     */
    public TreeNode Convert1(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert1(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert1(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }


    /**
     * 方法三：改进递归版
     * 解题思路：
     * 思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的
     */
    protected TreeNode leftLast = null;
    public TreeNode Convert2(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null){
            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert2(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert2(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }
}
