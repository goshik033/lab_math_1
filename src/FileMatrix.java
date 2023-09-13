import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMatrix {

    CatchExeption e = new CatchExeption();

    Matrix readFileDate() {
        System.out.println("Введите путь к файлу");
        String file = e.inputFile();
        System.out.println("Введите точность:");
        double eps = e.inputAccuracy();
        Matrix ourMatrix = createFileMatrix(file);
        ourMatrix.eps = eps;
        return ourMatrix;
    }

    Matrix createFileMatrix(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int size = Integer.parseInt(br.readLine().trim());
            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            br.close();
            double[][] matrix = new double[size][size];
            double[] b = new double[size];
            for (int i = 0; i < size; i++) {
                String[] line = lines.get(i).split(" ");
                b[i] = Double.parseDouble(line[size]);

                for (int j = 0; j < line.length - 1; j++) {
                    matrix[i][j] = Double.parseDouble(line[j]);
                }
            }
            Matrix ourMatrix = new Matrix(matrix, b);
            return ourMatrix;
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Матрица введена неверно,отредактируйте матрицу в файле, программа будет прекращена");
            System.exit(1);
        }
        return null;
    }
}
