Recursive approach is one of the solution but its not effective for larger graphs. So changed the solution to different way. 
**'Attaching Recursive approach folder just for reference.'**
Solution can be more optimized if we do not need to print the path.

Requirements:
    1. A non weighted graph is given
    2. A start vertex is given
    3. Finding the longest path and longest path distance in the graph from the start vertex

Approach: 
    1. Created a adjancency list from the inputs of dag.
    2. Applied topological sorting on it.(Each vertex is visited exactly once, and for each vertex, its neighbors are explored (i.e., all outgoing edges are processed))
    3. After the topological sorting, for each vertex, the algorithm iterates through all its neighbors (outgoing edges) to update the longest path.
    4.Once the longest path length is determined, you backtrack through the previousVertex array to reconstruct the actual path.


Does the solution work for larger graphs? 
    
    Answer: Yes, this approach should work fine for larger graphs, as both time and space complexity are linear with respect to the number of vertices and edges.

Can you think of any optimizations? 

    Answer: I can use memoization and recursion method to improve the optimization but still this method can end up with same time and space complexity. As well this approach may not be efficient for larger graphs as the deep recursion that could cause errors in Java, so change the approach recursive DFS to an iterative. Attaching the previous solution as well for reference.

What’s the computational complexity of your solution? 
    Answer: 
        Time Complexity: O(Vertices+Edges)
        Breakdown: Topological sorting : O(Vertices+Edges)
                   Finding longest path for each edge : O(Vertices+Edges)
                   Path finding: O(vertices)
        Space Complexity: O(V+E)
        Breakdown:
            Adjacency list to store the graph, which requires O(V+E) space.
            Visited[] array of size which takes O(V) space.
            Stack to store the vertices for the topological sort, which takes  O(V+E)
            Two arrays, length[] and previousVertex[], both of size O(V) space.
            The longest path is stored in a list, which in the worst case contains all O(V) space.

Are there any unusual cases that aren't handled? 
    Answer: Tried to cover almost all the test cases that handles 
            no vertices no edges, 
            single node dag, 
            linear dag, 
            multiple edges from one node
            multiple edges into one node
            Graph with one edge

            Cases not covered: Long Graphs


Did you fully read and understand the problem requirements? 

Answer: Yes, I have given my assumptions below.

Did you write and run tests? 

Answer: Yes, I have attached the testcases file.

Did you check for edge cases? 

Answer: I have checked for edgecases which I have think of.

Did you fully consider performance? Efficiency? Scalability? 

Answer: Yes, I have considered performance, effeciency and scability.

Did you answer the questions at the bottom of the explanation? 

Answer: Yes, I have.

Are you prepared to discuss your work if you are asked to participate in the interview process? 

Answer: Yes.

If you have relied on Artificial Intelligence to generate code, USFWS will know in the interview. Please do NOT rely on AI\
Answer: Sure.