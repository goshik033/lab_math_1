
public class Functions {
    Answer iter(Matrix m) {
        double res[] = new double[m.size];
        for (int i = 0; i < m.size; i++) {
            res[i] = m.b[i] / m.matrix[i][i];
        }
        double eps = m.eps;
        double xn[] = new double[m.size];
        double discrepancy[] = new double[m.size];
        boolean flag;
        int k = 0;
        do {
            k += 1;
            flag = true;
            for (int i = 0; i < m.size; i++) {
                xn[i] = m.b[i] / m.matrix[i][i];
                for (int j = 0; j < m.size; j++) {
                    if (i != j)
                        xn[i] -= m.matrix[i][j] / m.matrix[i][i] * res[j];
                }
            }
            for (int i = 0; i < m.size; i++) {
                if (Math.abs(xn[i] - res[i]) > eps) {
                    flag = false;
                    break;
                }
            }

            for (int i = 0; i < m.size; i++) {
                res[i] = xn[i];
            }
        } while (!flag);

        for (int i = 0; i < m.size; i++) {
            double summ = 0;
            for (int j = 0; j < m.size; j++) {
                summ += m.matrix[i][j] * res[j];
            }
            discrepancy[i] = summ - m.b[i];
        }
        Answer ans = new Answer(res, discrepancy, k);
        return ans;
    }

    boolean diagonalVerification(Matrix matrix) {
        double summ;
        boolean flag = true;
        for (int i = 0; i < matrix.size; i++) {
            summ = 0;
            for (int j = 0; j < matrix.size; j++) {
                if (i != j)
                    summ += Math.abs(matrix.matrix[i][j]);
            }
            if (matrix.matrix[i][i] <= summ)
                flag = false;
        }
        return flag;
    }

    double mmm[][];
    double bbb[];

    void matrixChanger(Matrix matrix, int index) {
        if (diagonalVerification(matrix)) {
            mmm = new double[matrix.size][matrix.size];
            bbb = new double[matrix.size];
            for (int i = 0; i < matrix.size; i++) {
                bbb[i] = matrix.b[i];
                for (int j = 0; j < matrix.size; j++) {
                    mmm[i][j] = matrix.matrix[i][j];
                }
            }
            return;
        }
        if (index < matrix.matrix.length) {
            for (int i = index + 1; i < matrix.matrix.length; i++) {
                double p = matrix.b[index];
                double[] t = matrix.matrix[index];

                matrix.matrix[index] = matrix.matrix[i];
                matrix.matrix[i] = t;


                matrix.b[index] = matrix.b[i];
                matrix.b[i] = p;
                if (diagonalVerification(matrix)) {

                    mmm = new double[matrix.size][matrix.size];
                    bbb = new double[matrix.size];
                    for (int k = 0; k < matrix.size; k++) {
                        bbb[k] = matrix.b[k];
                        for (int j = 0; j < matrix.size; j++) {
                            mmm[k][j] = matrix.matrix[k][j];
                        }
                    }
                    break;
                }

                matrixChanger(matrix, index + 1);
                p = matrix.b[index];
                t = matrix.matrix[index];

                matrix.matrix[index] = matrix.matrix[i];
                matrix.matrix[i] = t;

                matrix.b[index] = matrix.b[i];
                matrix.b[i] = p;
                if (diagonalVerification(matrix)) {

                    mmm = new double[matrix.size][matrix.size];
                    bbb = new double[matrix.size];
                    for (int k = 0; k < matrix.size; k++) {
                        bbb[k] = matrix.b[k];
                        for (int j = 0; j < matrix.size; j++) {
                            mmm[k][j] = matrix.matrix[k][j];
                        }
                    }
                    break;
                }
            }
        }
    }

    static class Answer {
        double res[];
        double inaccuracy[];
        int count;

        public Answer(double res[], double inaccuracy[], int count) {
            this.count = count;
            this.inaccuracy = inaccuracy;
            this.res = res;

        }
    }
}
