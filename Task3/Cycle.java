package Task3;
import java.util.*;

import Task1.Graph;
public class Cycle {
	 private int V; // Number of vertices
	 private ArrayList<Integer>[] adj; // Adjacency List representation   
	    public Cycle(int v) {
	        V = v;
	        adj = new ArrayList[v];
	        for (int i = 0; i < v; ++i)
	            adj[i] = new ArrayList(); }
	    
	    public void addEdge(int v, int w) {
	        adj[v].add(w);
	        adj[w].add(v);
		}
	    private boolean isCyclicUtil(int v, boolean visited[], int parent) {
	        visited[v] = true;
	        for (Integer i : adj[v]) {
	            if (!visited[i]) {
	                if (isCyclicUtil(i, visited, v))
	                    return true;
	            }
	            else if (i != parent)
	                return true;
	        }
	        return false;
	    }
	    public boolean isCyclic() {
	        boolean[] visited = new boolean[V];
	        Arrays.fill(visited, false);
	        for (int u = 0; u < V; u++)
	            if (!visited[u]) 
	                if (isCyclicUtil(u, visited, -1))
	                    return true;
	        return false;
	    }
	    public static void main(String args[]) {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.print("Enter the number of vertices: ");
	    	int V = sc.nextInt();
	    	System.out.print("Enter the number of edges: ");
	    	int E = sc.nextInt();

	    	Cycle g1 = new Cycle(V);
	        System.out.println("Enter edges in format: (start end):");
	        System.out.println("-"+0+" is first vertex, "+(V-1)+" is last vertex-");
	        for (int i = 0; i < E; i++) { //ask for input equal to n of edges
	            int source = sc.nextInt();
	            int destination = sc.nextInt();
	            g1.addEdge(source, destination);
	        }        
	        if (g1.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contain cycle");
	    }

}
