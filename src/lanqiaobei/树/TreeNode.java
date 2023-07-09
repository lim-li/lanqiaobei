package lanqiaobei.树;

/**
 * @author limli
 * @date 2023/2/25 16:42
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
