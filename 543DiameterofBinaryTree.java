class Solution {
    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = height(root);
        return dia;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        // currNode diameter = lh + rh
        dia = Math.max(lh + rh, dia);

        return Math.max(lh, rh) + 1;
    }
}