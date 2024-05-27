package Task7;
import java.util.*;
public class Incidence {
    private int[][] incidenceMatrix;
    private int Ver;
    private int Edges;
    public Incidence(int numVertices, int numEdges) {
        this.Ver = numVertices;
        this.Edges = numEdges;
        incidenceMatrix = new int[numVertices][numEdges];
    }
    public void addEdge(int edgeIndex, int vertex1, int vertex2) {
        incidenceMatrix[vertex1][edgeIndex] += 1;
        incidenceMatrix[vertex2][edgeIndex] += 1;
    }
    public void displayMatrix() {
        for (int i = 0; i < Ver; i++) {
            for (int j = 0; j < Edges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        Incidence graph = new Incidence(V, E);
        System.out.println("Enter the vertex pairs in format: (start end frequency):");
	    System.out.println("-"+0+" is first vertex, "+(V-1)+" is last vertex-");
        for (int i = 0; i < E; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            graph.addEdge(i, vertex1, vertex2);
            // If there are multiple edges between the same vertices, add them accordingly
            for (int j = 1; j < edgeCount; j++) {
                graph.addEdge(i, vertex1, vertex2);
            }
        }
        System.out.println("Incidence Matrix:");
        graph.displayMatrix();
        scanner.close();        
        //output:
        /*	 e d g e s
         * v
         * e
         * r
         * t
         * e
         * x
         */
    }
}