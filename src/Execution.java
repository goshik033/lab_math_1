
public class Execution {
    Functions functions = new Functions();
    Functions.Answer ans;

    void execute(Matrix matrix) {
        if (functions.diagonalVerification(matrix)) {
            System.out.print("\n" + "Матрица:" + "\n");
            for (int i = 0; i < matrix.size; i++) {
                for (int j = 0; j < matrix.size; j++) {
                    System.out.print(matrix.matrix[i][j] + " ");
                }
                System.out.print(matrix.b[i]);
                System.out.print("\n");
            }
            ans = functions.iter(matrix);
            System.out.print("\n");
            System.out.println("Невязка:");
            System.out.print("\n");
            for (int i = 0; i < matrix.size; i++) {
                System.out.println("[" + (i + 1) + "] = " + String.format("%.10f", ans.inaccuracy[i]));
            }
            System.out.print("\n");
            System.out.println("Количество итераций: " + ans.count);
            System.out.print("\n");
            System.out.println("Решение:");
            System.out.print("\n");
            for (int i = 0; i < matrix.size; i++) {
                System.out.println("[" + (i + 1) + "] = " + String.format("%.10f", ans.res[i]));
            }
        } else {
            functions.matrixChanger(matrix, 0);
            if (functions.mmm != null) {
                System.out.print("\n");
                System.out.println("Пришлось изменить матрицу, чтобы достичь диагонального преобладания");
                System.out.print("\n");
                for (int i = 0; i < matrix.size; i++) {
                    for (int j = 0; j < matrix.size; j++) {
                        System.out.print(functions.mmm[i][j] + " ");
                    }
                    System.out.print(functions.bbb[i]);
                    System.out.print("\n");
                }
                matrix.matrix = functions.mmm;
                matrix.b = functions.bbb;
                ans = functions.iter(matrix);
                System.out.print("\n");
                System.out.println("Невязка:");
                System.out.print("\n");
                for (int i = 0; i < matrix.size; i++) {
                    System.out.println("[" + (i + 1) + "] = " + String.format("%.10f", ans.inaccuracy[i]));
                }
                System.out.print("\n");
                System.out.println("Количество итераций: " + ans.count);
                System.out.print("\n");
                System.out.println("Решение:");
                System.out.print("\n");
                for (int i = 0; i < matrix.size; i++) {
                    System.out.println("[" + (i + 1) + "] = " + String.format("%.10f", ans.res[i]));
                }
            } else
                System.out.println("К сожалению, не получилось решить СЛАУ методом простых итераций");

        }
    }
}
