import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree {

    public static class TreeNode {
        int val;
        TreeNode left;

        TreeNode right;

        TreeNode root;

        public TreeNode() {
        }
        public TreeNode(TreeNode root) {
            this.root=root;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public int sum(){
            int sum = val;

            if(left != null){
                sum += left.sum();
            }

            if(right != null){
                sum+= right.sum();
            }

            return sum;
        }

        public boolean add(int x){
            if(root == null){
                root = new TreeNode(new TreeNode(x));
                return true;
            }

            if(x > root.val){

            }
            return false;
        }
    }

    public void add(TreeNode tree, int x){

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int max(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(max(root.left), max(root.right)),root.val);
    }

    public static int min(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(min(root.left), min(root.right)),root.val);
    }

    //Range Sum of BST
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public boolean checkTree(TreeNode root) {
        return root.val == root.right.val+root.left.val;
    }

    //Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        return new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
    }

    //Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }
    }

    //Increasing Order Search Tree
    //todo не получилось...
    public TreeNode increasingBST(TreeNode root) {
        return null;
    }

    //evaluate-boolean-binary-tree
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1 || root.val == 0){
            return root.val==1;
        }
        if(root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        if(root.val == 3){
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }

    private void helper(List<Integer> list, Node root){
        if(root.children == null){
            return;
        }else {
            for (int i = 0; i < root.children.size(); i++) {
                helper(list, root.children.get(i));
                list.add(root.children.get(i).val);
            }
        }
    }
    //N-ary Tree Postorder Traversal
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    //path-sum
    public boolean helper(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.right == null && root.left == null){
            return root.val == targetSum;
        }
        return helper(root.right, targetSum - root.val) || helper(root.left, targetSum - root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null || root.val == targetSum){
            return false;
        }
        return helper(root, targetSum);
    }

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            int curSum = 0;
            TreeNode currentNode = null;
            for (int i = 0; i < n; i++) {
                currentNode = queue.remove();
                curSum += currentNode.val;
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            sum = curSum;


        }
        return sum;
    }
    public static void printBST(TreeNode root) {
        if(root == null){
            return;
        }
        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);
    }

    public static void printBFS(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            System.out.print(currentNode.val + " ");
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tr = new Tree();
        TreeNode tree = new TreeNode(20,
             new TreeNode(7,
                     new TreeNode(4, null, new TreeNode(6)),
                     new TreeNode(9)),
             new TreeNode(35,
                     new TreeNode(31, new TreeNode(28),null),
                     new TreeNode(40,
                             new TreeNode(38),new TreeNode(52))));

        //printBST(tree);
        System.out.println();
        //printBFS(tree);
        TreeNode tree1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5),null),null),null),null);
        //System.out.println(tr.hasPathSum(tree1, 6));
        System.out.println(tr.deepestLeavesSum(tree));
        System.out.println("Амиго очень умный");
    }

}


