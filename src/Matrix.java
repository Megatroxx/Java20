public class Matrix<T extends Number> {
    private T[][] matrix;

    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public T[][] add(Matrix<T> other) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        T[][] result = (T[][]) new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = ((Number) matrix[i][j]).doubleValue() + ((Number) other.matrix[i][j]).doubleValue();
                result[i][j] = (T) Double.valueOf(sum);
            }
        }

        return result;
    }

    public T[][] multiply(Matrix<T> other) {
        int rows = matrix.length;
        int cols = other.matrix[0].length;
        int inner = matrix[0].length;

        T[][] result = (T[][]) new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = 0;
                for (int k = 0; k < inner; k++) {
                    sum += ((Number) matrix[i][k]).doubleValue() * ((Number) other.matrix[k][j]).doubleValue();
                }
                result[i][j] = (T) Double.valueOf(sum);
            }
        }

        return result;
    }

    public double determinant(T[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return (Double)matrix[0][0];
        }
        double det = 0;
        for (int i = 0; i < n; i++) {
            T[][] subMatrix = (T[][])new Number[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        subMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        subMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            det += ((i % 2 == 0) ? 1 : -1) * matrix[0][i].doubleValue() * determinant(subMatrix);
        }
        return det;
    }

    public static <T extends Number> T[][] subtract(T[][] matrix1, T[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        T[][] result = (T[][]) new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = matrix1[i][j].doubleValue() - matrix2[i][j].doubleValue();
                result[i][j] = (T) Double.valueOf(sum);
            }
        }
        return result;
    }

    public T[][] inverse(T[][] matrix) {
        int n = matrix.length;
        T[][] adjugate = adjoint(matrix);
        double determinant = (Double)determinant(matrix);
        T[][] inverse = (T[][])new Number[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double r = adjugate[i][j].doubleValue() / determinant;
                inverse[i][j] = (T)Double.valueOf(r);
            }
        }

        return inverse;
    }

    public T[][] adjoint(T[][] matrix) {
        int n = matrix.length;
        T[][] adjugate =  (T[][]) new Number[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double x = cofactor(matrix, i, j);
                adjugate[i][j] = (T)Double.valueOf(x);
            }
        }
        return adjugate;
    }
    public double cofactor(T[][] matrix, int p, int q) {
        int n = matrix.length;
        T[][] temp =  (T[][]) new Number[n][n];
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return determinant(temp);
    }


}
