package Task2;

import java.util.*;
public class Matrix {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);	        
	        System.out.print("Enter the number of vertices: ");
	        int V = sc.nextInt();	        
	        int[][] adjacencyMatrix = new int[V][V];	        
	        System.out.println("Enter the adjacency matrix:");
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                adjacencyMatrix[i][j] = sc.nextInt();
	            }
	        }	        
	        // Creating HashMap to store edges and their count
	        Map<String, Integer> edgeCount = new HashMap<>();	        
	        // Loop through the upper triangular part of the adjacency matrix
	        for (int i = 0; i < V; i++) {
	            for (int j = i; j < V; j++) {
	                if (adjacencyMatrix[i][j] == 1) {
	                    String edge = "(" + i + ", " + j + ")";
	                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 1) + 1);
	                }
	            }
	        }	        
	        // Displaying edges and their count
	        System.out.println("\nEdges of the graph and their counts:");
	        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	        	        sc.close();
	    }
	}
