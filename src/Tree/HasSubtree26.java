package Tree;
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class HasSubtree26 {
    //1.a中找到和b的根节点一样的节点r;2.判断a中以r为根的子树是不是包含和树b一样的结构
    //所以：如果根节点相同就递归调用isSubTree；根不同，就判断root1的左子/右子是否与root2相同；
    //注意树1、2为空的情况；
    public static boolean hasSubtree(TreeNode root1,TreeNode root2){
        if (root1==null||root2==null)
            return false;
        return isSubtree(root1,root2)||hasSubtree(root1.left,root2)||hasSubtree(root1.right,root2);
    }

    private static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2==null)
            return true;//说明第二棵树遍历结束啦，匹配成功
        if (root1==null)
            return false;
        if (root1.val==root2.val)
            return isSubtree(root1.right,root2.right)&&isSubtree(root1.left,root2.left);
        else
            return false;
    }
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);
        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(root1,root3));
    }
}
