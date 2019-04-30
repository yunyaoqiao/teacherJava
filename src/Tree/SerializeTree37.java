package Tree;

import java.util.LinkedList;
import java.util.Queue;

//请实现两个函数，分别用来序列化和反序列化二叉树
public class SerializeTree37 {
    //思路一：参考7用“前序+中序”构造一个二叉树。故序列化为把树序列化为前序+中序，反序列时构造处理
    //思路二：反序列化时在根节点读出来时就可以开始，不用全部读完流中的数据。
    //仍然把二叉树分为左右中三部分。为了能快点读到根点，采用前序遍历。

    //对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点不为空时，
    //           在转化val所得的字符之后添加一个’,’作为分割; 对于空节点则以 ‘#,’ 代替。
    //对于反序列化：将字符串按照“，”进行分割，插入到队列中，然后依次从队列中取出字符建立节点，递归创建一个二叉树。
    static String Serialize(TreeNode root) {
        if (root==null)
            return "#,";//注意！！返回值是字符串，要用双引号，而且是“#，”
        StringBuffer res=new StringBuffer(root.val+",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();//递归实际上是从底部开始的，底下的做好了，再继续往上
    }
    static TreeNode Deserialize(String str) {
        //拆分序列化字符串，插入队列。先入先出--->任然可以先处理根
        String[] res=str.split(",");
        Queue<String> queue=new LinkedList<>();
        for (int i=0;i<res.length;i++)
            queue.offer(res[i]);
        return pre(queue);
    }

    private static TreeNode pre(Queue<String> queue) {
        String val=queue.poll();
        if (val.equals("#"))
            return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));//将根点加入。即要处理的点
        node.left=pre(queue);//处理左子
        node.right=pre(queue);//处理右子
        return node;//返回二叉树

    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("原始树："+root);
        String result = Serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode deserializeRoot = Deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
    }
}
