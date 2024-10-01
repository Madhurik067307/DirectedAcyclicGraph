// This is for reference - not the main code
package RecursiveApproach;

import java.util.ArrayList;
import java.util.List;

public class Dag {
private final int V;  
private final List<List<Integer>> adjList;  

public Dag(int V) {
   this.V = V;
   adjList = new ArrayList<>(V);
   for (int i = 0; i < V; i++) {
       adjList.add(new ArrayList<>());
   }
}
public void addEdge(int u, int v) {
   adjList.get(u).add(v);
}
public int findLongestPath(int start) {
	int[] memo=new int[V];
    int count=findLongestPathRecursive(start, memo);
    List<Integer> path=new ArrayList<>();
    path.add(start);
    int vertex=start;
    while(!(adjList.get(vertex).size()==0))
    {
        int maxVertex=adjList.get(vertex).get(0);
    	for(int i=1;i<adjList.get(vertex).size();i++)
    	{
    		if(memo[adjList.get(vertex).get(i)]>memo[maxVertex])
    		{
    			maxVertex=adjList.get(vertex).get(i);
    		}
    	}
    	path.add(maxVertex);
    	vertex=maxVertex;
    }
    System.out.println("Path for longest distance "+path);
    return count;
}
private int findLongestPathRecursive(int node, int[] memo) {

    if (memo[node] != 0) {
        return memo[node];
    }

    if (adjList.get(node).size() == 0) {
        return 1;
    }

    int maxLength = 1; 

    for (int neighbor : adjList.get(node)) {
        int currentLength = 1 + findLongestPathRecursive(neighbor, memo); 
        maxLength = Math.max(maxLength, currentLength);  
    }

    memo[node] = maxLength;  
    return maxLength;
}
}

