
/* 

class Node 
	int data;
	Node left;
	Node right;
*/

public static void topView(Node root) {
    if (root == null)
        return;

    class QueueNode {
        Node node;
        int hd;

        QueueNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    Queue<QueueNode> queue = new LinkedList<>();
    Map<Integer, Integer> topViewMap = new TreeMap<>();
    queue.add(new QueueNode(root, 0));

    while (!queue.isEmpty()) {
        QueueNode current = queue.poll();
        int hd = current.hd;
        Node node = current.node;

        if (!topViewMap.containsKey(hd)) {
            topViewMap.put(hd, node.data);
        }

        if (node.left != null) {
            queue.add(new QueueNode(node.left, hd - 1));
        }

        if (node.right != null) {
            queue.add(new QueueNode(node.right, hd + 1));
        }
    }

    for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
        System.out.print(entry.getValue() + " ");
    }

}