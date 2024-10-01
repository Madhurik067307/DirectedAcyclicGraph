import java.util.*;

class DAG {
    private final int noOfVertices;  
    private final List<List<Integer>> adjancencyList;  

    public DAG(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjancencyList = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            adjancencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjancencyList.get(u).add(v);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adjancencyList.get(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(v);  
    }

    public List<Integer> findLongestPath(int startVertex) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noOfVertices];
        
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        int[] length = new int[noOfVertices];
        Arrays.fill(length, Integer.MIN_VALUE);
        length[startVertex] = 0;

        int[] previousVertex = new int[noOfVertices];
        Arrays.fill(previousVertex, -1);  

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (length[u] != Integer.MIN_VALUE) {
                for (int v : adjancencyList.get(u)) {
                    if (length[v] < length[u] + 1) {
                        length[v] = length[u] + 1;  
                        previousVertex[v] = u;     
                    }
                }
            }
        }

        int endVertex = -1;
        int longestPathLength = Integer.MIN_VALUE;
        for (int i = 0; i < noOfVertices; i++) {
            if (length[i] > longestPathLength) {
                longestPathLength = length[i];
                endVertex = i;
            }
        }

        List<Integer> longestPath = new ArrayList<>();
        if (endVertex != -1) {
            for (int v = endVertex; v != -1; v = previousVertex[v]) {
                longestPath.add(v);
            }
        }

        Collections.reverse(longestPath);

        return longestPath;
    }
}


