package 程序员面试经典.c3;

/**
 * Created by Administrator on 2017/3/17.
 */
public class fourpointone {
    public static int getHeight(TreeNode parent){
        if (parent == null)
            return 0;
        return Math.max(getHeight(parent.left),getHeight(parent.right))+1;
    }

    public static boolean isBalance(TreeNode parent){
        if (parent == null)
            return true;

        int heightDiff = getHeight(parent.left)-getHeight(parent.right);

        if (Math.abs(heightDiff)>1){
            return false;
        }else {
            return isBalance(parent.left)&&isBalance(parent.right);
        }
    }

    public static void main(String[] args) {

        TreeNode nodeFuck = new TreeNode(111);
        TreeNode node1 = new TreeNode(59,null,nodeFuck);
        TreeNode node2 = new TreeNode(57,null,node1);
        TreeNode node3 = new TreeNode(45);
        TreeNode node4 = new TreeNode(55,node3,node2);
        TreeNode node5 = new TreeNode(101);
        TreeNode node6 = new TreeNode(107,node5,null);
        TreeNode node7 = new TreeNode(67);
        TreeNode node8 = new TreeNode(100,node7,node6);
        TreeNode node9= new TreeNode(60,node4,node8);

        System.out.println(isBalance(node9));
    }
}
