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
}
