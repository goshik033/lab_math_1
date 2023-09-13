import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CatchExeption {
    public int inputSize() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine();
                int size = Integer.parseInt(str);
                return size;
            } catch (NumberFormatException wrongForm) {
                System.out.println("Неверный формат, попробуйте еще раз");

            }
        }
    }

    public double inputAccuracy() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine();
                double accuracy = Double.parseDouble(str);
                return accuracy;
            } catch (NumberFormatException wrongForm) {
                System.out.println("Неверный формат, попробуйте еще раз");

            }
        }
    }

    Matrix inputMatrixString(int size) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                double ln[][] = new double[size][size];
                double b[] = new double[size];
                for (int i = 0; i < size; i++) {
                    String line[] = in.nextLine().split(" ");
                    b[i] = Double.parseDouble(line[size]);
                    for (int j = 0; j < line.length - 1; j++) {
                        ln[i][j] = Double.parseDouble(line[j]);
                    }
                }
                return new Matrix(ln, b);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
                System.out.println("Неверный формат, введите матрицу заново");

            }
        }

    }

    String inputFile() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String file = in.nextLine();
                BufferedReader br = new BufferedReader(new FileReader(file));
                return file;
            } catch (FileNotFoundException f) {
                System.out.println("Указан неверный путь, попробуйте еще раз");
            }
        }
    }
}
