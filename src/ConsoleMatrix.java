
public class ConsoleMatrix {

    CatchExeption e = new CatchExeption();

    Matrix readConsoleDate() {
        System.out.println("Введите размер матрицы");
        int size = e.inputSize();
        while (size > 20 || size < 1) {
            System.out.println("Неверный размер матрицы, введите еще раз");
            size = e.inputSize();
        }
        System.out.println("Введите точность:");
        double eps = e.inputAccuracy();
        Matrix ourMatrix = createConsoleMatrix(size);
        ourMatrix.eps = eps;
        return ourMatrix;
    }

    Matrix createConsoleMatrix(int size) {
        System.out.println("Введите матрицу");
        Matrix ourMatrix = e.inputMatrixString(size);
        return ourMatrix;
    }

}
