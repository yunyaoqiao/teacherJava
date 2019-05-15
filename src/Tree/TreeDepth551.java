package Tree;

import java.util.LinkedList;
import java.util.Queue;

//输入一棵二叉树，求该树的深度。
// 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
// 最长路径的长度为树的深度。
public class TreeDepth551 {
    //1.如果只有根，则深度为1
    //2.如果只有左子/右子，为左子/右子的深度+1；
    //3.如果有左右子，则为左右子中较大的一个的深度+1
    public static int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=TreeDepth(root.left)+1;
        int right=TreeDepth(root.right)+1;
        return left>right?left:right;
    }
    //层次遍历。每遍历一层，deep 加 1，直接到最后一层，输出 deep。???
    public static int TreeDepth1(TreeNode root) {
        if (root==null)
            return 0;
        int deep=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int start=0,end=1;
        while (!queue.isEmpty()){
            TreeNode noed=queue.poll();
            start++;
            if (noed.left!=null)
                queue.offer(noed.left);
            if (noed.right!=null)
                queue.offer(noed.right);
            if (start==end){
                end=queue.size();
                start=0;
                deep++;
            }
        }
        return deep;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(TreeDepth(root));
        System.out.println(TreeDepth1(root));
    }
}
