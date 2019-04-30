package Tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

//问题1.从上往下打印出二叉树的每个节点，同层节点从左至右打印。--广度优先遍历
//问题2.分行从上到下打印二叉树--广度优先遍历
//问题3.请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。非广度，不用队列
public class PrintFromTopToBottom32 {
    //借助队列。为啥？方法是想每取到一个根，就同时存下他的两个子；
    //            8
    //          /   \
    //         6     10
    //        / \    / \
    //       5   7   9  11。所以取到8，就把6、10存入容器. 再从容器头取6，把5，7存入容器尾部
    //所以就是一个先入先出。
    //思路:1.每打印一个节点，如果有子节点，就把子节点加入队列末尾。2.从队列头取节点。3.重复1、2，直到队列为空停下
    //总结：不论是图/树的广度优先遍历：都用队列。1.把起始点放入队列 2.从队列头部取一个节点，遍历该点能到达的节点加入队尾。重复直到队列为空
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        //注意：根节点为空！！
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            res.add(root.val);//把节点的值加入到最终要打印的广序遍历容器中
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
        return res;
    }

    //问题2，我们需要两个变量，一个start记录当前层已经打印的节点个数，一个end记录前当层所有的节点个数，
// 当 start == end 时，表时当前层遍历完了，就可以开始下一层遍历。
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> temp = new ArrayList<>();//存放每一行中的值
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();//将存储每行值的容器存起来
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);//offer(E e):将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于add(E)，后者可能无法插入元素，而只是抛出一个异常。
        int start = 0, end = 1;//记录每行已经打印过点的数量；end记录该行总共的点数
        while (!queue.isEmpty()) {
            pRoot = queue.remove();//把根点入队。remove():获取并移除此队列的头。
            //poll()：获取并移除此队列的头，如果此队列为空，则返回 null。
            temp.add(pRoot.val);
            start++;
            if (pRoot.left != null)//取根的左右
                queue.add(pRoot.left);
            if (pRoot.right != null)
                queue.add(pRoot.right);
            if (start == end) {//代表该行读完了
                start = 0;
                res.add(temp);
                temp = new ArrayList<>();
                end = queue.size();//队列的长度。处理点1时，queue里面加入了2、3，所以该行结束位置是2。
                // 处理2点，queue加入3，4，(start=1)!=(end=2),说明该行没有遍历完，要继续从队列头部取出
            }
        }
        return res;
    }

    //设两个栈，s1存放奇数层，s2存放偶数层
    //为啥用栈：         8
    //    //          /   \
    //    //         6     10
    //    //        / \    / \
    //    //       5   7   9  11。所以取到8，就把6、10存入容器. 再从容器头取10先存入。说明是后进先出
    //遍历s1节点（里面放了奇数层的点），按照左子树、右子树的顺序加入s1，
    //遍历s2节点（里面放了偶数层的点），按照右子树、左子树的顺序加入s2
    public static ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int flag = 1;
        s1.push(pRoot);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (flag % 2 != 0) {//正处理的是奇数层
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();//取出栈顶元素
                    temp.add(node.val);
                    if (node.left != null)
                        s2.push(node.left);
                    if (node.right != null)
                        s2.push(node.right);
                }
            }
            if (flag % 2 == 0) {//正处理偶数层
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null)
                        s1.push(node.right);//偶数层先右 后左
                    if (node.left != null)
                        s1.push(node.left);
                }
            }
            res.add(temp);
            temp = new ArrayList<>();
            //或temp.clear();
            flag++;
        }//当s1或s2为空，代表读完了一行，此时就要把temp加入到res里了
    return res;
}
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printFromTopToBottom(root);
        Print(root);
        ArrayList a=PrintZ(root);
        Iterator iterator=a.iterator();
        while (iterator.hasNext()){
            Object temp=iterator.next();
            System.out.println(temp+" ");
            iterator.remove();
        }
    }
}
