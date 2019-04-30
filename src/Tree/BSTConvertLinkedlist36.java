package Tree;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class BSTConvertLinkedlist36 {
    private static TreeNode head;
    private static TreeNode end;
    //递归解决。让左子、右子排好序：原来指向左子的变为指向前一个点的指针、原来指向右子的变为指向后一个点的指针
    //BST的中序遍历。从根点开始：把树分为左右两个部分，将左子最大数与根连+右子最大数与根连。然后让左右重复该步骤。

    //1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
    //2、定位到左链表的最后一个节点(左子树最右边的节点)
    //3、如果左子树链表不为空，则将当前root追加到左子树链表后
    //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
    //5、如果右子树链表不为空，将右子树链表追加到当前root后
    //6，根据左子树链表是否为空返回的整体双向链表的头节点
    //Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
    public static TreeNode convert(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null || root.right == null)
            return root;//只有一个根节点，返回根点就行
        //1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
        TreeNode left=convert(root.left);
        //2、定位到左链表的最后一个节点(左子树最右边的节点)
        TreeNode last=left;
        while (last!=null&&last.right!=null){
            last=last.right;//last指向了左子树的最大节点
        }
        //3、如果左子树链表不为空，则将当前root追加到左子树链表后
        if (left!=null){
            last.right=root;
            root.left=last;//即根与左树最大节点相连
        }
        //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
        TreeNode right=convert(root.right);
        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if (right!=null){
            root.right=right;
            right.left=root;//即根与右子头节点相连
        }
        //6，根据左子树链表是否为空返回的整体双向链表的头节点
        return left!=null?left:root;
    }

    //双向链表中，left相当于前向点。right相当于后向点
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
        TreeNode result = convert(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        System.out.println(result.right.right.right.val);//10
    }
}
