package ru.vsu.cs.Smirnov_p_a;
//разделить подклассы
public class Matrix {
    static class Matrix3x3 {
        int row;
        int col;
        int[][] matrix3x3;

        Matrix3x3() {
            this.row = 3;
            this.col = 3;
            this.matrix3x3 = new int[this.row][this.col];
        }

        Matrix3x3(int[][] matrix) {
            this.row = matrix.length;
            this.col = matrix[0].length;
            this.matrix3x3 = matrix;
        }

        int GetElement(int n, int m) {
            return this.matrix3x3[n][m];
        }

        void SetElement(int n, int m, int value) {
            matrix3x3[n][m] = value;
        }

        int GetVerticalLength() {
            return this.matrix3x3.length;
        }

        int GetHorizontalLength() {
            return this.matrix3x3[0].length;
        }
//row col вместо i j final
        Matrix3x3 MatrixSum(Matrix3x3 matrix1, Matrix3x3 matrix2, char sym) {
            for (int i = 0; i < GetVerticalLength(); i++) {
                for (int j = 0; j < GetHorizontalLength(); j++) {
                    switch (sym) {
                        case '+' -> matrix1.SetElement(i, j, matrix1.GetElement(i, j) + matrix2.GetElement(i, j));
                        case '-' -> matrix1.SetElement(i, j, matrix1.GetElement(i, j) - matrix2.GetElement(i, j));
                        default -> throw new IllegalArgumentException();
                    }
                }
            }
            return matrix1;
        }

        Vector.Vector3 MatxVec3(Matrix3x3 matrix, Vector.Vector3 vector) {
            Vector.Vector3 result = new Vector.Vector3(0, 0, 0);
            result.a = matrix.GetElement(0, 0) * vector.a + matrix.GetElement(0, 1) * vector.b + matrix.GetElement(0, 2) * vector.c;
            result.b = matrix.GetElement(1, 0) * vector.a + matrix.GetElement(1, 1) * vector.b + matrix.GetElement(1, 2) * vector.c;
            result.c = matrix.GetElement(2, 0) * vector.a + matrix.GetElement(2, 1) * vector.b + matrix.GetElement(2, 2) * vector.c;
            return result;
        }

        int[][] MatxMat(Matrix3x3 matrix1, Matrix3x3 matrix2) {
            int[][] matxMat = new int[matrix1.GetHorizontalLength()][matrix2.GetVerticalLength()];
            for (int i = 0; i < matrix1.GetVerticalLength(); i++) {
                for (int j = 0; j < matrix2.GetHorizontalLength(); j++) {
                    matxMat[i][j] = 0;
                    for (int k = 0; k < matrix1.GetHorizontalLength(); k++) {
                        matxMat[i][j] += matrix1.GetElement(i, k) * matrix2.GetElement(k, j);
                    }
                }
            }
            return matxMat;
        }

        void TrMat(Matrix3x3 matrix) {
            for (int i = 0; i < matrix.GetVerticalLength(); i++) {
                for (int j = i + 1; j < matrix.GetHorizontalLength(); j++) {
                    int temp = matrix.GetElement(i, j);
                    matrix.SetElement(i, j, matrix.GetElement(j, i));
                    matrix.SetElement(j, i, temp);
                }
            }
        }

        Matrix3x3 ZeroMatrix() {
            Matrix3x3 nullMatrix = new Matrix3x3();
            for (int i = 0; i < nullMatrix.GetVerticalLength(); i++) {
                for (int j = 0; j < nullMatrix.GetHorizontalLength(); j++) {
                    nullMatrix.SetElement(i, j, 0);
                }
            }
            return nullMatrix;
        }
//Identity
        Matrix3x3 OneMatrix() {
            Matrix3x3 oneMatrix = new Matrix3x3();
            for (int i = 0; i < oneMatrix.GetVerticalLength(); i++) {
                for (int j = 0; j < oneMatrix.GetHorizontalLength(); j++) {
                    if (i != j) {
                        oneMatrix.SetElement(i, j, 0);
                    } else {
                        oneMatrix.SetElement(i, j, 1);
                    }
                }
            }
            return oneMatrix;
        }
    }

    static class Matrix4x4 {
        int row;
        int col;
        int[][] matrix4x4;

        Matrix4x4() {
            this.row = 4;
            this.col = 4;
            this.matrix4x4 = new int[this.row][this.col];
        }

        Matrix4x4(int[][] matrix) {
            this.row = matrix.length;
            this.col = matrix[0].length;
            this.matrix4x4 = matrix;
        }

        int GetElement(int n, int m) {
            return this.matrix4x4[n][m];
        }

        void SetElement(int n, int m, int value) {
            matrix4x4[n][m] = value;
        }

        int GetVerticalLength() {
            return this.matrix4x4.length;
        }

        int GetHorizontalLength() {
            return this.matrix4x4[0].length;
        }

        Matrix4x4 MatrixSum(Matrix4x4 matrix1, Matrix4x4 matrix2, char sym) {
            for (int i = 0; i < GetVerticalLength(); i++) {
                for (int j = 0; j < GetHorizontalLength(); j++) {
                    switch (sym) {
                        case '+' -> matrix1.SetElement(i, j, matrix1.GetElement(i, j) + matrix2.GetElement(i, j));
                        case '-' -> matrix1.SetElement(i, j, matrix1.GetElement(i, j) - matrix2.GetElement(i, j));
                        default -> throw new IllegalArgumentException();
                    }
                }
            }
            return matrix1;
        }

        Vector.Vector4 MatxVec(Matrix4x4 matrix, Vector.Vector4 vector) {
            Vector.Vector4 result = new Vector.Vector4(0, 0, 0, 0);
            result.a = matrix.GetElement(0, 0) * vector.a + matrix.GetElement(0, 1) * vector.b + matrix.GetElement(0, 2) * vector.c + matrix.GetElement(0, 3) * vector.d;
            result.b = matrix.GetElement(1, 0) * vector.a + matrix.GetElement(1, 1) * vector.b + matrix.GetElement(1, 2) * vector.c + matrix.GetElement(1, 3) * vector.d;
            result.c = matrix.GetElement(2, 0) * vector.a + matrix.GetElement(2, 1) * vector.b + matrix.GetElement(2, 2) * vector.c + matrix.GetElement(2, 3) * vector.d;
            result.d = matrix.GetElement(3, 0) * vector.a + matrix.GetElement(3, 1) * vector.b + matrix.GetElement(3, 2) * vector.c + matrix.GetElement(3, 3) * vector.d;
            return result;
        }

        int[][] MatxMat(Matrix4x4 matrix1, Matrix4x4 matrix2) {
            int[][] matxMat = new int[matrix1.GetHorizontalLength()][matrix2.GetVerticalLength()];
            for (int i = 0; i < matrix1.GetVerticalLength(); i++) {
                for (int j = 0; j < matrix2.GetHorizontalLength(); j++) {
                    matxMat[i][j] = 0;
                    for (int k = 0; k < matrix1.GetHorizontalLength(); k++) {
                        matxMat[i][j] += matrix1.GetElement(i, k) * matrix2.GetElement(k, j);
                    }
                }
            }
            return matxMat;
        }

        void TrMat(Matrix4x4 matrix) {
            for (int i = 0; i < matrix.GetVerticalLength(); i++) {
                for (int j = i + 1; j < matrix.GetHorizontalLength(); j++) {
                    int temp = matrix.GetElement(i, j);
                    matrix.SetElement(i, j, matrix.GetElement(j, i));
                    matrix.SetElement(j, i, temp);
                }
            }
        }

        Matrix4x4 NullMatrix() {
            Matrix4x4 nullMatrix = new Matrix4x4();
            for (int i = 0; i < nullMatrix.GetVerticalLength(); i++) {
                for (int j = 0; j < nullMatrix.GetHorizontalLength(); j++) {
                    nullMatrix.SetElement(i, j, 0);
                }
            }
            return nullMatrix;
        }

        Matrix4x4 OneMatrix() {
            Matrix4x4 oneMatrix = new Matrix4x4();
            for (int i = 0; i < oneMatrix.GetVerticalLength(); i++) {
                for (int j = 0; j < oneMatrix.GetHorizontalLength(); j++) {
                    if (i != j) {
                        oneMatrix.SetElement(i, j, 0);
                    } else {
                        oneMatrix.SetElement(i, j, 1);
                    }
                }
            }
            return oneMatrix;
        }
    }
}