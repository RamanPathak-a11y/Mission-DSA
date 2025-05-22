class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    public void dfs(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
        } else {
            path += node.val + "->";
            if (node.left != null)
                dfs(node.left, path, paths);
            if (node.right != null)
                dfs(node.right, path, paths);

        }

    }
}