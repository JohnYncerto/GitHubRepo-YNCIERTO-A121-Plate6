package Task8;
import java.util.*;
class gIsomorphism {
    public static boolean isIsomorphic(int[][] adjMatrix1, int[][] adjMatrix2, String[] vertices1, String[] vertices2) {
        // Check if the graphs have the same number of vertices
        int V1 = vertices1.length;
        int V2 = vertices2.length;
        if (V1 != V2) {
            return false;
        }
        // Check if the degree sequences of both graphs are the same
        Map<Integer, Integer> degreeCount1 = getDegreeCount(adjMatrix1);
        Map<Integer, Integer> degreeCount2 = getDegreeCount(adjMatrix2);
        if (!degreeCount1.equals(degreeCount2)) {
            return false;
        }
        // Check if the adjacency matrices are isomorphic
        return areIsomorphic(adjMatrix1, adjMatrix2, V1, new HashMap<>(), new boolean[V1], 0);
    }
    // Function to check if the adjacency matrices are isomorphic recursively
    private static boolean areIsomorphic(int[][] adjMatrix1, int[][] adjMatrix2, int V,
                                         Map<Integer, Integer> mapping, boolean[] visited, int index) {
        // If all vertices are mapped, check if the mapping is valid
        if (index == visited.length) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (adjMatrix1[i][j] != adjMatrix2[mapping.get(i)][mapping.get(j)]) {
                        return false;
                    }
                }
            }
            return true;
        }
        // Try all possible mappings for the current vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                mapping.put(index, i);
                if (areIsomorphic(adjMatrix1, adjMatrix2, V, mapping, visited, index + 1)) {
                    return true;
                }
                visited[i] = false;
                mapping.remove(index);
            }
        }
        return false;
    }
    // Function to calculate the degree count of vertices in the adjacency matrix
    private static Map<Integer, Integer> getDegreeCount(int[][] adjMatrix) {
        Map<Integer, Integer> degreeCount = new HashMap<>();
        int V = adjMatrix.length;
        for (int i = 0; i < V; i++) {
            int degree = 0;
            for (int j = 0; j < V; j++) {
                degree += adjMatrix[i][j];
            }
            degreeCount.put(degree, degreeCount.getOrDefault(degree, 0) + 1);
        }
        return degreeCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices for graph 1: ");
        int V1 = sc.nextInt();
        System.out.println("Enter the vertices for the first graph (separated by spaces):");
        String[] vertices1 = sc.nextLine().trim().split("\\s+");
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter the adjacency matrix for graph 1:");
        int[][] graph1 = new int[V1][V1];
        for (int i = 0; i < V1; i++) {
            for (int j = 0; j < V1; j++) {
                graph1[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the number of vertices for graph 2: ");
        int V2 = sc.nextInt();
        System.out.println("Enter the vertices for the second graph (separated by spaces):");
        String[] vertices2 = sc.nextLine().trim().split("\\s+");
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter the adjacency matrix for graph 2:");
        int[][] graph2 = new int[V2][V2];
        for (int i = 0; i < V2; i++) {
            for (int j = 0; j < V2; j++) {
                graph2[i][j] = sc.nextInt();
            }
        }
        if (isIsomorphic(graph1, graph2, vertices1, vertices2)) {
            System.out.println("Graphs are isomorphic.");
        } else {
            System.out.println("Graphs are not isomorphic.");
        }
        sc.close();
    }
}