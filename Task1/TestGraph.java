package Task1;

import java.util.Scanner;
public class TestGraph {
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the number of vertices: ");
	        int V = sc.nextInt();
	        System.out.print("Enter the number of edges: ");
	        int E = sc.nextInt();

	        Graph g = new Graph(V);

	        System.out.println("Enter edges in format: (start end):");
	        for (int i = 0; i < E; i++) { //ask for input equal to n of edges
	            int source = sc.nextInt();
	            int destination = sc.nextInt();
	            g.addEdge(source, destination);
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
