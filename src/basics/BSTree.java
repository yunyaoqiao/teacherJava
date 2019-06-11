package basics;


public class BSTree {
    class Node {
        int data;
        Node lChild, rChild;

        public Node(int data) {
            this.data = data;
            lChild = null;
            rChild = null;
        }
    }
    private Node root;
    public BSTree() {
        root = null;
    }
    //递归查找
    public boolean BSTSearch(int key){
        return BSTSearch(key,root);

    }
    private boolean BSTSearch(int key, Node node) {
        if (node==null)
            return false;//节点为null，停止查询并且返回false
        if (node.data==key)
            return true;//找到key,停止查询并且返回true
        else if (node.data<key)
            return BSTSearch(key,node.rChild);//现在遍历到的数<key，说明key应该在右子树
        else
            return BSTSearch(key,node.lChild);
    }

    //递归插入，要注意排除null的情况；
    public boolean insertBST(int key){
        if (root==null){//排除null情况
            root=new Node(key);
            return true;
        }
        return insertBST(key,root);
    }
    private boolean insertBST(int key, Node node) {
        if (node.data>key){//当前节点>key,说明应该把新节点key加在左子
            if (node.lChild==null){
                node.lChild=new Node(key);
                return true;
            }
            else
                return insertBST(key,node.lChild);
        }else if (node.data<key){//当前节点<key,说明应该把新节点key加在右子
            if (node.rChild==null){
                node.rChild=new Node(key);
                return true;
            }
            else
                return insertBST(key,node.rChild);
        }else {
            System.out.println("重复");
            return false;
        }
    }

    //非递归
    public boolean BSTSearch2(int key){
        Node p=root;
        while (p!=null){
            if (p.data>key)
                p=p.lChild;
            else if (p.data<key)
                p=p.rChild;
            else
                return true;
        }
        return false;
    }
    public boolean insertBST2(int key){
        Node newNode=new Node(key);//新节点
        if (root==null){
            root=newNode;
            return true;
        }
        Node f=null;//父节点
        Node p=root;//当前节点
        while (p!=null){
            if (p.data>key){//当前点比较大，所以新插入的点应该为其左子
                f=p;
                p=p.lChild;
            }
            else if (p.data<key){
                f=p;
                p=p.rChild;
            }
            else {
                System.out.println("重复");
                return false;
            }
        }
        if (f.data>key)
            f.lChild=newNode;
        else if (f.data<key)
            f.rChild=newNode;
        return true;
    }

    public static void main(String[] args) {
        BSTree aTree = new BSTree();
        int[] arr = {62, 88, 58, 47, 35, 73, 51, 99, 37, 93};
        for (int a : arr) {
            aTree.insertBST(a);
        }
        System.out.println(aTree.BSTSearch(35));
    }
}