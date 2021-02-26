import GraphOp.GraphOp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (!in.hasNextInt()) {
            System.out.println("That's not an integer! Enter another number");
            in.next();
        }

        int n = in.nextInt();

        GraphOp graph = new GraphOp(n);
        graph.displayMatrix();
    }
}
