package Tree;
//输入一棵树的根节点，输入两个被观察节点，求这两个节点的最低(最近)公共祖先。
public class GetLowestCommonParentBST68 {
    //该题首先要和面试官确定是否为二叉树，得到肯定答复后，还要确定是否为二叉搜索树，是否有父指针，或者仅仅是普通二叉树。
    //1.树为二叉搜索树时，最低公共祖先结点的大小--->遍历找到比第一个节点大，比第二个节点小的节点即可。
    //2.如果是父子间有双向指针的树：由下往上看，转化为找两个链表的第一个公共节点问题
    //3.树为普通树时，使用遍历将子结点的信息往上传递。
    // 在左右子树中进行查找是否存在两个树结点，如果两个树结点分别在左右子树上，说明该根结点就是它们的最低公共祖先。
    public static TreeNode getLowestCommonParentBST(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        if(root.val>p.val&&root.val>q.val)
            return getLowestCommonParentBST(root.left,p,q);
        //当前节点的值比两个节点的值都大，那么最低的祖先节点一定在当前节点的左子树中，则遍历当前节点的左子节点；

        if(root.val<p.val&&root.val<q.val)
            return getLowestCommonParentBST(root.right,p,q);
        //若当前节点的值比两个节点的值都小，那么最低的祖先节点一定在当前节点的右子树中，则遍历当前节点的右子节点；
        else
            return root;//直到找到一个节点，位于两个节点值的中间，则找到了最低的公共祖先节点。
    }

    /*
     * 普通二叉树
     * 将下面结点的信息利用递归s往上传递
     */
    public static TreeNode getLowestCommonParent(TreeNode root,TreeNode node1,TreeNode node2) {
        if(root==null || root== node1 || root== node2)
            return root;
        TreeNode left=getLowestCommonParent(root.left, node1, node2);
        TreeNode right=getLowestCommonParent(root.right, node1, node2);
        if(left==null)
            return right;
        if(right==null)
            return left;
        else
            return root;
    }
//普通树，不是二叉树
//如果只是一个包含父到子的指针的普通树：
//  3.1）如果不能使用额外空间，从根节点开始判断他的子树是否包含那两个节点，找到最小的的子树即可
//        时间复杂度o(n^2)(此为最差，平均不太好算。。。),空间复杂度为o(1)
//  3.2) 如果能用额外空间，可以遍历两次(深度优先)获取根节点到那两个节点的路径，然后求两个路径的最后一个公共节点
//        时间复杂度o(n)，空间复杂度o(logn)

    public static void main(String[] args) {
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(getLowestCommonParentBST(root,root.left.left,root.left.right).val);
        System.out.println(getLowestCommonParent(root,root.left.left,root.left.right).val);
    }
}
