package Tree;
//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class IsSymmetrical28 {
    //递归。根节点的左右子树相同，左子树的左子树和右子树的右子树相同，并且左子树的右子树和右子树的左子树相同即可。
    static boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
//注意特殊情况：左右为空；或左/或右为空
    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left==null&&right==null)
            return true;
        else if (left==null||right==null)
            return false;
        else if (left.val==right.val)
            return isSymmetrical(left.left,right.right)&&
                    isSymmetrical(left.right,right.left);
        return false;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(isSymmetrical(root));
    }
}
