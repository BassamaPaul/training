/**
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/

public int[] findOrder(int numCourses, int[][] prerequisites) {
    int size = prerequisites.length;

    boolean[] marked = new boolean[numCourses];
    boolean[] done = new boolean[numCourses];
    List<Integer>[] adj = toAdjacencyList(numCourses, prerequisites);

    int[] order_ = {};
    for (int v = 0; v < numCourses; v++) {
        if (!marked[v] && search(adj, v, marked, done))
            return order_;
    }

    ArrayList<Integer> order = new ArrayList<Integer>();
    Arrays.fill(marked, false);
    for (int v = 0; v < numCourses; v++) {
        if (!marked[v])
            dfs(adj, marked, order, v);
    }

    order_ = new int[order.size()];
    int i = 0;
    for (Integer v : order) {
        order_[order.size() - i - 1] = v;
        i++;
    }

    return order_;
}

private void dfs(List<Integer>[] adj, boolean[] used, List<Integer> order, int s) {
    used[s] = true;
    for (int w : adj[s]) {
        if (!used[w]) 
            dfs(adj, used, order, w);
    }
    order.add(0, s);
}

private List<Integer>[] toAdjacencyList(int numCourses, int[][] p) {
    int size = p.length;
    List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
    for (int i = 0; i < size; i++) {
        if (adj[p[i][0]] == null) {
            adj[p[i][0]] = new ArrayList<>();
        }
        adj[p[i][0]].add(p[i][1]);
    }
    return adj;
}

private boolean search(List<Integer>[] adj, int s, boolean[] marked, boolean[] done) {
    marked[s] = true;
    done[s] = true;
    if (adj[s] == null) {
        adj[s] = new ArrayList();
    }
    for (int w : adj[s]) {
        if ((!marked[w] && search(adj, w, marked, done)) || done[w])
            return true;
    }
    done[s] = false;
    return false;
}
