package lanqiaobei.树;

/**
 * @author limli
 * @date 2023/2/25 16:43
 */
public class 树的遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(6);

       // qdfs(root);
        System.out.println(maxdepth(root));
    }
    //递归前序遍历 跟左右
    public static void qdfs(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + ">");
        qdfs(root.left);
       //System.out.print(root.val + ">");
        qdfs(root.right);
        //System.out.print(root.val + ">");
    }
    public static int maxdepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxdepth(root.left);
        int right = maxdepth(root.right);
        return Math.max(left,right)+1;
    }
}
