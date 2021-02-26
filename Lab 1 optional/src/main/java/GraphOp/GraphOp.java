package GraphOp;

/**
 * Class created for all operations over a random graph
 */

public class GraphOp {
    private int[][] matrix;
    private int nrVertices;
    private boolean[] visited;
    private int[][] partialTree;

    /**
     * Constructor created to initialize nrVertices, visited and partialTree
     * Constructor also creates the adjacency matrix of random graph
     * @param n represents the number of vertices entered from the keyboard
     */

    public GraphOp(int n) {
        this.nrVertices = n;
        this.matrix = new int[nrVertices][nrVertices];

        for (int i = 0; i < nrVertices; i++) {
            for (int j = 0; j < nrVertices; j++) {
                if (i != j) {
                    matrix[i][j] = ((int) (Math.random() * 100)) % 2;
                }
            }
        }

        this.visited = new boolean[nrVertices];
        this.partialTree = new int[nrVertices][nrVertices];
    }

    /**
     * Method to display the adjacency matrix created in constructor
     */

    public void displayMatrix() {
        System.out.println("Here is the adjancency matrix:");

        for (int i = 0; i < nrVertices; i++) {
            for (int j = 0; j < nrVertices; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Method to determine if the graph is connected
     * If it is not connected, calls method printConnectedComponents
     * If it is connected, calls method printPartialTree
     */

    public void isConnected() {
        System.out.println("Result of depth-first search:");
        dfs(0);

        for (boolean i : visited) {
            if (i == false) {
                System.out.println("The graph is not connected.");
                printConnectedComponents();
                return;
            }
        }

        System.out.println("The graph is connected.");
        printPartialTree();
    }

    /**
     * Method for depth-first search, to determine if the graph is connected
     * Method also creates partial tree of graph
     * @param startVertex is the vertex whose neighbours we are looking for
     */

    public void dfs(int startVertex) {
        if (visited[startVertex] == false) {
            visited[startVertex] = true;
            System.out.println(startVertex);
            for (int vertex = 0; vertex < nrVertices; vertex++) {
                if (matrix[startVertex][vertex] == 1 && visited[vertex] == false) {
                    partialTree[startVertex][vertex] = 1;
                    dfs(vertex);
                }
            }
        }
    }

    /**
     * Method to print the partial tree of the graph if it is connected
     */

    public void printPartialTree() {
        System.out.println("Here is the adjacency matrix of the partial tree:");

        for (int i = 0; i < nrVertices; i++) {
            for (int j = 0; j < nrVertices; j++) {
                System.out.print(partialTree[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Method to print the connected components if the graph is not connected
     */

    public void printConnectedComponents() {
        for (boolean i : visited) {
            i = false;
        }

        System.out.println("Here is a connected component:");
        dfs(0);
        System.out.println();

        boolean flag = false;

        while (flag == false) {
            int i = 1;
            while (visited[i]) {
                i++;
            }
            if(i>=nrVertices) {
                flag=true;
            }
            else {
                System.out.println("Here is another connected component:");
                dfs(i);
                System.out.println();
            }
        }
    }
}
