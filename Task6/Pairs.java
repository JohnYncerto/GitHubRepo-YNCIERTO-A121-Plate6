package Task6;

import java.util.*;
public class Pairs {
    private int[][] adjacencyMatrix;
    private int V;
    public Pairs(int v) {
        this.V = v;
        adjacencyMatrix = new int[V][V];
    }
    public void addEdge(int vertex1, int vertex2) {
        // Increment the count to display the number of times an edge appears
        adjacencyMatrix[vertex1][vertex2] += 1; // Assuming unweighted graph, assign weight as needed
        adjacencyMatrix[vertex2][vertex1] += 1; // Comment out for directed
    }
    public void displayMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println(); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        Pairs graph = new Pairs(V);
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        System.out.println("Enter the vertex pairs associated with the edges:");
	    System.out.println("-"+0+" is first vertex, "+(V-1)+" is last vertex-");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }
        System.out.println("Adjacency Matrix:");
        graph.displayMatrix();
        scanner.close();
    }
}