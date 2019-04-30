package Tree;

import java.util.ArrayList;
import java.util.Stack;

//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class FindPath34 {
    //路径都是从根作为开始点的，所以用到了前序遍历。而且要用容器记录下路径(数组/栈)
    //画图分析：1.前序遍历访问到一共节点，就把节点加入路径，并用目标值减去该值。
    //2.如果该节点是叶子节点，且目标值减去该值为0，则把这条路径加入返回值数组中。
    //如果该节点不是叶子，就继续访问其子节点
    //3.当前节点访问完毕，用递归函数返回到父节点-->所以要先在路径中删除当前点，使得
    //返回父节点时路径刚好是根到父亲节点的路径。
//    static ArrayList<Integer> temp=new ArrayList<>();
    static Stack<Integer> temp=new Stack<>();
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();//创建要在外部，如果在递归函数内部，那么就会清空前面加入的数字
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root==null)
            return res;//一定要写，这样的话到达叶子点才会有返回，满足条件会跳到迭代函数上。
        target=target-root.val;
        temp.add(root.val);
        if (target==0&&root.left==null&&root.right==null)
            res.add(new ArrayList<>(temp));//注意！！一定要新new temp,表示一个满足和为22的路径已经找到，要开始存一共新路径
        else {
            findPath(root.left,target);
            findPath(root.right,target);
        }
//        temp.remove(temp.size()-1);//去掉temp数组中最后加入的数字
        temp.pop();//弹出栈顶后继续递归。
        return res;

    }
    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(findPath(root,22));
    }
}
