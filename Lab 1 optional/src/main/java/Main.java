import GraphOp.GraphOp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //validate the input
        while (!in.hasNextInt()) {
            System.out.println("That's not an integer! Enter another number");
            in.next();
        }

        int n = in.nextInt();

        GraphOp graph = new GraphOp(n); //create random graph
        graph.displayMatrix(); //call method to display the adjacency matrix
        graph.isConnected(); //call method to determine if the graph is connected
    }
}
