package Tree;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class ReConstructBinaryTree7 {
public static TreeNode reConstructBinaryTree(int[] pre, int[] in){
    //1.考虑特殊情况，前中序为空；前中不等
    //2.遍历“中序”找到根->preorder[preorder_start]。
    if(pre==null || in==null || pre.length==0 || pre.length!=in.length)
        return null;//
    return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);//前序，前序开始，前序结束；中序，中序开始，中序结束
}
    public static TreeNode constructBinaryTree(int[] pre, int ps, int pe,
                                               int[] in, int is, int ie){
        if(ps > pe || is > ie){
            return null;
        }
        TreeNode treeNode=new TreeNode(pre[ps]);//构建一个新树，根是前序的开始节点
        for(int i = is; i<=ie; i++){//遍历中序，找到根节点
            if(in[i] == pre[ps]){
                treeNode.left = constructBinaryTree(pre, ps+1, ps+i-is, in, is, i-1);//在前序和中序中左子树的构成部分。
                //左子树构成：前序，前序开始=前序开始+1，前序结束=ps+1+(i-1)-is；中序，中序开始=中序开始，中序结束=i-1（左子树长度为i-1）
                treeNode.right = constructBinaryTree(pre, ps+i-is+1, pe, in, i+1, ie);
                break;
            }
        }
        return treeNode;
    }
   /* public static void middleSort(TreeNode root) {
        if (root == null) {
            return;
        }
        middleSort(root.getLeft());//获取左子
        System.out.println(root.getVal());
        middleSort(root.getRight());//获取右子
    }*/
    public static void afterSort(TreeNode root) {
        if (root == null) {
            return;
        }
        afterSort(root.getLeft());
        afterSort(root.getRight());
        System.out.println(root.getVal());
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
        TreeNode root = reConstructBinaryTree(pre,in);
        afterSort(root);

    }

}

