package Task5;
import java.util.*;
public class Bipartite {
	private ArrayList<Integer>[] adj;
	private int V; // Number of vertices	    
	    public Bipartite(int V) {
	        this.V = V;
	        adj = new ArrayList[V];
	        for (int i = 0; i < V; i++) {
	            adj[i] = new ArrayList<>(); }
	    }
	    public void addEdge(int v, int w) {
	        adj[v].add(w);
	        adj[w].add(v);
	    }    
	    public static boolean isBipartite(ArrayList<Integer>[] adj, int V) {
	        int[] colors = new int[V];
	        Arrays.fill(colors, -1); // Initialize all vertices with no color	        
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < V; i++) {
	            if (colors[i] == -1) {
	                colors[i] = 0; // Assign color 0 to the first vertex
	                queue.offer(i);	                
	                while (!queue.isEmpty()) {
	                    int vertex = queue.poll();
	                    for (int neighbor : adj[vertex]) {
	                        if (colors[neighbor] == -1) {
	                            colors[neighbor] = 1 - colors[vertex]; // Assign opposite color to neighbor
	                            queue.offer(neighbor);
	                        } else if (colors[neighbor] == colors[vertex]) {
	                            return false; // Graph is not bipartite
	                        }
	                    }
	                }
	            }
	        }	        
	        return true; // Graph is bipartite
	    }	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);	        
	        System.out.print("Enter the number of vertices on one side: ");
	        int V1 = sc.nextInt();
	        System.out.print("Enter the number of vertices on the other side: ");
	        int V2 = sc.nextInt();
	        int V = V1 + V2; // Total number of vertices	        
	        Bipartite graph = new Bipartite(V);	        
	        System.out.print("Enter the number of edges: ");
	        int E = sc.nextInt();
	        System.out.println("Enter edges connecting vertices from one side to the other:");
	        System.out.println("Vertices on one side: 0 to " + (V1 - 1));
	        System.out.println("Vertices on the other side: " + V1 + " to " + (V - 1));	        
	        boolean validEdges = true; // Flag to track if all edges are valid
	        HashMap<Integer, Integer> edgeCount = new HashMap<>();
	        for (int i = 0; i < E; i++) {
	            int src = sc.nextInt();
	            int dest = sc.nextInt();
	            if (src> dest) {
		             int temp = src;
		             src = dest;
		             dest = temp; }
	            int edgeHash = src * V + dest;
	            edgeCount.put(edgeHash, edgeCount.getOrDefault(edgeHash, 0) + 1);
	            // Ensure that edges only connect vertices from one side to the other
	            if ((src >= 0 && src < V1 && dest >= V1 && dest < V) ||
	                (dest >= 0 && dest < V1 && src >= V1 && src < V)) {
	                graph.addEdge(src, dest);
	            } else if(src == dest || (edgeCount.get(edgeHash) > 1)) {
	                	System.out.println("The graph is no longer simple.");
	                    System.exit(0);
	            }else {
	                validEdges = false; }
	        }	        	        
	        if (validEdges && isBipartite(graph.adj, V)) {
	            System.out.println("The graph is bipartite.");
	        } else {
	            System.out.println("The graph is not bipartite.");
	        }	        
	        sc.close();
	    }
}
