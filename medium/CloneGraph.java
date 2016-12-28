/**
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/


public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
        return null;
    }

    LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

    queue.add(node);
    map.put(node, newHead);

    while (!queue.isEmpty()) {
        UndirectedGraphNode current = queue.pop();
        List<UndirectedGraphNode> list = current.neighbors;

        for (UndirectedGraphNode un : list) {
            if (!map.containsKey(un)) {
                UndirectedGraphNode copy = new UndirectedGraphNode(un.label);
                map.put(un, copy);
                map.get(current).neighbors.add(copy);
                queue.add(un);
            } else {
                map.get(current).neighbors.add(map.get(un));
            }
        }
    }

    return newHead;
}
