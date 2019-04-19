import java.util.ArrayList;
import java.util.List;
public class TreeNode implements Cloneable {
    @Override
    protected TreeNode clone() throws CloneNotSupportedException {
        return (TreeNode)super.clone();
    }

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public static void main(String[] args) {

//      TreeNode root = null;
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);

        root1.left=root2;
//      System.out.println(root.left.val);
//      for(int i=1;i<2;i++){
////           System.out.println(i);
//      }
//        System.out.println(root1.val);
//        System.out.println(root2.val);
//        root1=root2;
//        System.out.println("-----------");
//        System.out.println(root1.val);
//        System.out.println(root2.val);
//        root2.val=3;
//        System.out.println("-----------");
//        System.out.println(root1.val);
//        System.out.println(root2.val);
        try{
        TreeNode p = root1.clone();
        p.left=root3;
        System.out.println(p.equals(root1));
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e); // won't happen
        }

    }
}
