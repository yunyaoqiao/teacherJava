package Tree;
//操作给定的二叉树，将其变换为源二叉树的镜像。//重点是树的遍历
public class Mirror27 {
    //通过对以上两棵树的观察，我们可以总结出这两棵树的根节点相同，但它们的左、右两个子节点交换了位置。
    // 所以我们可以得出求一棵树的镜像的过程：1.先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。
    // 当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像。

    public static void mirror(TreeNode root) {
        if (root==null)
            return;
        //当没叶子节点，就返回
        if (root.left==null&&root.right==null)
            return;
        //如果有子节点，就交换
        TreeNode treeNode=root.left;
        root.left=root.right;
        root.right=treeNode;//首先交换了6、10.

        //前序遍历。递归遍历其子节点
        if (root.left!=null)
            mirror(root.left);//首先变为mirror(10),先处理完左侧的10，11，9的交换，直到根的子树为空停下
        if (root.right!=null)
            mirror(root.right);//首先变为mirror(6)
    }

    //前序遍历
    /*public static void beforeSort(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getVal());
        beforeSort(root.getLeft());
        beforeSort(root.getRight());
    }*/
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(root);
        mirror(root);
        System.out.println(root);
    }
}
