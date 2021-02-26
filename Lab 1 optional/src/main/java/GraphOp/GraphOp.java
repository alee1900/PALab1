package GraphOp;

public class GraphOp {
    private int[][] matrix;
    private int nrVertices;

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
    }

    public void displayMatrix() {
        System.out.println("Here is the adjancency matrix:");
        for (int i = 0; i < nrVertices; i++) {
            for (int j = 0; j < nrVertices; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}
