package jianzhioffer.shu;

public class ex1 {
    /**
     * 二叉树镜像
     *
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     */
    /**
     * 要注意代码的健壮行，当root为null时不做操作。
     *
     * 自顶向下一层一层的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode p = new TreeNode(0);
            p=root.left; //为输入结点的左子树创建一个副本
            root.left=root.right; //令输入结点的左子树等于该结点的右子树
            root.right=p;   //令输入结点的右子树等于该节点的左子树
            if(root.left!=null){ //左子树不为空
                Mirror(root.left); //对左子树也镜像
            }
            if(root.right!=null){   //同理
                Mirror(root.right);
            }
        }
    }


}
