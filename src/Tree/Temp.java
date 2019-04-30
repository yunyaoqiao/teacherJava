package Tree;

public class Temp {
    static class TreeNode<T> {
        private T val;//根
        private TreeNode<T> left;//左节点
        private TreeNode<T> right;//右节点

        public TreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }//每一个树，由值+左右两个节点构成
        public T getVal() {
            return val;
        }
        public void setVal(T val){
            this.val=val;
        }

        public TreeNode<T> getLeft() {
            return left;
        }
        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }
        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        public static void middleSort(TreeNode root) {
            if (root == null) {
                return;
            }
            middleSort(root.getLeft());//获取左子
            System.out.println(root.getVal().toString());
            middleSort(root.getRight());//获取右子
        }
        public static void beforeSort(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.println(root.getVal().toString());
            beforeSort(root.getLeft());
            beforeSort(root.getRight());
        }
        public static void afterSort(TreeNode root) {
            if (root == null) {
                return;
            }
            afterSort(root.getLeft());
            afterSort(root.getRight());
            System.out.println(root.getVal().toString());
        }
        public static void main(String[] args) {
            TreeNode<Integer> root = new TreeNode<>(10);
            root.setLeft(new TreeNode<>(9));
            root.setRight(new TreeNode<>(21));
            root.getLeft().setLeft(new TreeNode<>(2));
            middleSort(root);
        }

    }
}


