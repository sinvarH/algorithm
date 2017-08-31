package 程序员面试经典.c3;

/**
 * Created by Administrator on 2017/3/16.
 */
public class TreeNode {
    public int val = 0 ;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode (int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
