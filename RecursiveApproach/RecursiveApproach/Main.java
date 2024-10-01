package RecursiveApproach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {

        System.out.println("Enter the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int testCaseNumber = 1;

        while ((line = br.readLine()) != null) {
            line = line.trim();  

            if (line.isEmpty()) {
                continue; 
            }

            int vertices = Integer.parseInt(line);

            if (vertices == 0) {
                System.out.println("Test Case " + testCaseNumber + ": No vertices in the graph.");
                System.out.println();
                testCaseNumber++;
                br.readLine(); 
                continue;
            }

            Dag dag = new Dag(vertices);

            line = br.readLine().trim();
            int edges = Integer.parseInt(line);

            for (int i = 0; i < edges; i++) {
                line = br.readLine().trim();
                String[] edge = line.split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                dag.addEdge(u, v);
            }

            line = br.readLine().trim();
            int startVertex = Integer.parseInt(line);

            int longestPath = dag.findLongestPath(startVertex);

            System.out.println("Test Case " + testCaseNumber + ":");
            System.out.println("Longest Path from vertex " + startVertex + " is: " + (longestPath-1));
            System.out.println();

            testCaseNumber++;
        }

        br.close();
    }
}
   




