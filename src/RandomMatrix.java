public class RandomMatrix {
    CatchExeption e = new CatchExeption();

    Matrix readRandomDate() {
        System.out.println("Введите размер матрицы");
        int size = e.inputSize();
        while (size > 20 || size < 1) {
            System.out.println("Неверный размер матрицы, введите еще раз");
            size = e.inputSize();
        }
        System.out.println("Введите точность:");
        double eps = e.inputAccuracy();
        Matrix ourMatrix = createDiagonalRandomMatrix(size);
        ourMatrix.eps = eps;
        return ourMatrix;
    }

    //    public Matrix createRandomMatrix(int size){
////        double matrix[][]=new double[size][size];
////        double b []=new double[size];
////        for (int i =0; i<size;i++){
////            b[i]=Math.random() *200-100;
////            for (int j=0; j<size+1;j++){
////                matrix[i][j] = Math.random() *200-100;
////            }
////        }
////        Matrix ourMatrix=new Matrix(matrix,b);
////        return ourMatrix;
////
////
////    }
    public Matrix createDiagonalRandomMatrix(int size) {
        double[][] matrix = new double[size][size];
        double b[] = new double[size];
        for (int i = 0; i < size; i++) {
            double summ = 0;
            b[i] = Math.random() * 200 - 100;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    matrix[i][j] = Math.random() * 200 - 100;
                    summ += Math.abs(matrix[i][j]);
                }
            }
            matrix[i][i] = summ + Math.abs(Math.random() * 200 - 100);
        }
        Matrix ourMatrix = new Matrix(matrix, b);
        return ourMatrix;

    }
}



