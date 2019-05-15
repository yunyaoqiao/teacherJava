package Tree;
//输入二叉树的根节点，判断该树是否是平衡二叉树。
// 如果某二叉树的任意节点的左右子树深度之差不超过1，则该树是平衡二叉树。
public class IsBalanced552 {
    //方法一：借助于上一题二叉树的深度，从根节点开始逐点判断树的左右子树的深度（高度）差值是否满足平衡要求。
    //每一次获取节点有需要从当前节点遍历到叶节点来算高度，因此需要每个节点被多次遍历，不是好方法
    public static boolean isBalanced(TreeNode root){
        if (root==null)
            return true;
        if (Math.abs(getDepth(root.left)-getDepth(root.right))<=1)//得到树的左右子树高度差，得到的方法是再次遍历
            return isBalanced(root.left)&&isBalanced(root.right);
        else
            return false;
    }
    public static int getDepth(TreeNode root) {
        if( root == null ) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return ( left > right ? left : right ) + 1;//获得树的高度
    }

    //如果用后序遍历，那么访问某一个节点时已经访问了它的左右子树。同时，在访问节点时记录下它的深度，
    // 也就是说：一棵树只要知道他左右子树的深度以及左右子树是不是平衡二叉树，就可以判定这棵树是不是平衡二叉树
    // 这样我们就能通过遍历一遍完成整棵树的平衡性判断。
    private static boolean isBalanced = false;
    public static boolean isBalanced2(TreeNode root){
        treeDepth(root);
        return isBalanced;
    }
    private static int treeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        int depth=(left>right?left:right)+1;//分别求得左右两个子树中较大的那一个
        if (Math.abs(left-right)<=1)
            isBalanced=true;
        else
            isBalanced=false;
        return depth;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isBalanced2(root));
    }
}
