package Tree;

import java.util.Stack;

//找出二叉搜索树的第k大节点。例如，在下图的树里，第3大节点的值为4，输入该树的根节点，3，则输出4。
//        5
//       / \
//      3   7
//    / \   / \
//   2  4  6   8
public class KthNodeInBST54{
    //二叉搜索树的中序遍历是有序的。可以引入一个计数器，
    //每访问一个节点，计数器+1，当计数器等于k时，被访问节点就是该二叉搜索树的第k大节点。
    static int count=0;
    static TreeNode node;
    public static TreeNode kthNode(TreeNode root,int k){
        helper(root,k);
        return node;
    }

    private static void helper(TreeNode root, int k) {
        if (root==null||count>k)
            return;
        helper(root.left,k);
        count++;
        if (count==k)
            node=root;
//        System.out.print("qqqq:"+root.getVal()+" ");
        helper(root.right,k);
    }

    //非递归法. 构造一个栈，思路同 中序遍历的非递归法


    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
//        System.out.println(kthNode(root,3).val);//4
//        System.out.println(kthNode(root,2).val);//3
        System.out.println(kthNode(root,5).val);//7
    }
}
