public class Matrix {
    double[][] matrix;
    int size;
    double eps;
    double[] b;

    public Matrix(double[][] matrix, double[] b) {
        this.matrix = matrix;
        this.size = matrix.length;
        this.b = b;
    }
}
