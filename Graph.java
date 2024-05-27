package Task1;
import java.util.*;
public class Graph {
	 private int Ver;// n of vertices
	 ArrayList<ArrayList<Integer> > adj;
	    Graph(int v) {
	        this.Ver=v;
	        adj = new ArrayList<>();
	        for (int i = 0; i < Ver; i++) {
	            adj.add(i, new ArrayList<>()); } }//end of class
	    public void addEdge(int src, int dest) {										
	        adj.get(src).add(dest);
	        adj.get(dest).add(src); }//end of class
	    public void DFSUtil(int v, boolean[] visited) {
	        visited[v] = true;
	        for (int x : adj.get(v)) {
	            if (!visited[x])
	                DFSUtil(x, visited); } }//end of class
	    public boolean isConnected() {
	        boolean visited[] = new boolean[Ver];
	        Arrays.fill(visited, false);
	        DFSUtil(0, visited);
	        for (boolean visit : visited) {
	        	if (!visit) { // if any is unvisited
	        		return false; } }//end of for
	        return true; }//end of class
	    public int nConnected() {
	        boolean visited[] = new boolean[Ver];
	        int count = 0;
	        for (int i = 0; i < Ver; ++i) {
	            if (!visited[i]) {
	                DFSUtil(i, visited);
	                count++; }
	        } return count;// number of count
	    }//end of class    
	    public static void main(String args[]) {
			 Scanner sc = new Scanner(System.in);
		     System.out.print("Enter the number of vertices: ");
		     int V = sc.nextInt();
		     System.out.print("Enter the number of edges: ");
		     int E = sc.nextInt();
		     Graph g = new Graph(V);
		     System.out.println("Enter edges in format: (start end):");
		     System.out.println("- "+0+" is first vertex, "+(V-1)+" is last vertex -");
		     HashMap<Integer, Integer> edgeCount = new HashMap<>();
		     for (int i = 0; i < E; i++) { // Ask for input equal to n of edges
		         int src = sc.nextInt();
		         int dest = sc.nextInt();   
		         // Ensure that source is smaller than destination for undirected edges
		         if (src> dest) {
		             int temp = src;
		             src = dest;
		             dest = temp; }
		         int edgeHash = src * V + dest;
		         edgeCount.put(edgeHash, edgeCount.getOrDefault(edgeHash, 0) + 1);		         
		         if (src == dest || edgeCount.get(edgeHash) > 1) {
		             System.out.println("The graph is no longer simple.");
		             System.exit(0);
		         } else {
		             g.addEdge(src, dest); }
		     }
		     if (g.isConnected()) {
		            System.out.println("The graph is connected.");
		     } else {
		            System.out.println("The graph is not connected.");
		            int numComponents = g.nConnected();
		            System.out.println("Number of connected components: " + numComponents);
		            }	
		    }   
	}

	



