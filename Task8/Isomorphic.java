package Task8;
import java.util.*;
public class Isomorphic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vertices for the first graph (separated by spaces):");
        String[] vertices1 = scanner.nextLine().trim().split("\\s+");
        System.out.println("Enter the vertices for the second graph (separated by spaces):");
        String[] vertices2 = scanner.nextLine().trim().split("\\s+");
        if (areIsomorphic(vertices1, vertices2)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }
        scanner.close();
    }
    public static boolean areIsomorphic(String[] vertices1, String[] vertices2) {
        // Check if number of vertices is different
        if (vertices1.length != vertices2.length) {
            return false;
        }
        // Generate all possible permutations of vertices for the first graph
        List<String[]> permutations = new ArrayList<>();
        generatePermutations(vertices1, 0, permutations);
        // Check each permutation against the second set of vertices
        for (String[] permutation : permutations) {
            if (Arrays.equals(permutation, vertices2)) {
                return true;
            }
        }
        return false;
    }
    private static void generatePermutations(String[] vertices, int index, List<String[]> permutations) {
        if (index == vertices.length - 1) {
            permutations.add(vertices.clone());
        } else {
            for (int i = index; i < vertices.length; i++) {
                swap(vertices, index, i);
                generatePermutations(vertices, index + 1, permutations);
                swap(vertices, index, i);
            }
        }
    }
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}