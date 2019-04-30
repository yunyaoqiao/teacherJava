package Tree;
//给定二叉树和其中一个节点，找到中序遍历序列的下一个节点。
// 树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
public class NextNodeInBinaryTrees8 {
    //??????
    //1.输入的节点有右子树。下一个节点是：右子树节点为根节点的左子节点
    //2.输入的节点没有右子树：i.节点为其父的左子，下一个节点是：其父
    // ii.节点为其父的右子，下一个节点是：沿着父节点遍历，直到找到某一个点是它父节点的左子节点
    //iii.节点没有父，就返回null
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;
        else if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null)
                pNode = pNode.left;
            return pNode;
        }
        while(pNode.next!=null){
            if(pNode.next.left==pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
    public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.left.next = root;
        root.right = new TreeLinkNode(3);
        root.right.next = root;
        root.left.left = new TreeLinkNode(4);
        root.left.left.next = root.left;
        root.left.right = new TreeLinkNode(5);
        root.left.right.next = root.left;

        System.out.println((root.left.left).val);
        System.out.println(GetNext(root.left).val);
        System.out.println(GetNext(root.left.right).val);
        System.out.println(GetNext(root).val);
        System.out.println(GetNext(root.right));
    }
}
