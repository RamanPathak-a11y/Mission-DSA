class Solution {
    public boolean isValidSerialization(String preorder) {
        int balance = 1;
        String[] nodes = preorder.split(",");

        for (String node : nodes) {
            if (balance <= 0)
                return false;
            if (node.equals("#"))
                balance--;
            else
                balance++;
        }

        return balance == 0;
    }
}