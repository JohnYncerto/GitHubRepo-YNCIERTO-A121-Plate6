package Task4;
import java.util.*;
public class DegGraph {
	private ArrayList<Integer>[] adj;
	private int V; // Number of vertices
	private int deg;
	public DegGraph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new ArrayList(); }	
	public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices: ");
		int V = sc.nextInt();
		Map<Integer, Integer> degreeMap = new HashMap<>();
		System.out.print("Enter the number of edges: ");
		int E = sc.nextInt();
		DegGraph g1 = new DegGraph(V);
		System.out.println("Enter edges in format: (start end):");
	    System.out.println("-"+0+" is first vertex, "+(V-1)+" is last vertex-");
	    for (int i = 0; i < E; i++) { //ask for input equal to n of edges
	        int source = sc.nextInt();
	        int destination = sc.nextInt();
	        degreeMap.put(source, degreeMap.getOrDefault(source, 0) + 1);
	        degreeMap.put(destination, degreeMap.getOrDefault(destination, 0) + 1);
	    }        		
	    System.out.println("Vertex degrees:");
        for (int i = 0; i < V; i++) {
            int degree = degreeMap.getOrDefault(i, 0);
            System.out.println("Vertex " + i + ": " + degree);
        }

    
	}
}