package ru.vsu.cs.Smirnov_p_a;


public class Vector {
    static class Vector2 {
        int a;
        int b;

        Vector2(int a, int b) {
            this.a = a;
            this.b = b;
        }

        Vector2 Vec2Sum(Vector2 vector1, Vector2 vector2, char sym) {
            switch (sym) {
                case '+' -> {
                    vector1.a += vector2.a;
                    vector1.b += vector2.b;
                }
                case '-' -> {
                    vector1.a -= vector2.a;
                    vector1.b -= vector2.b;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        Vector2 Vec2Scal(final Vector2 vector1, int num, char sym) {
            switch (sym) {
                case '*' -> {
                    vector1.a *= num;
                    vector1.b *= num;
                }
                case '/' -> {
                    vector1.a /= num;
                    vector1.b /= num;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        double Vec2Length(Vector2 vector1) {
            return Math.sqrt(vector1.a ^ 2 + vector1.b ^ 2);
        }

        Vector2 Vec2Norm(Vector2 vector1) {
            vector1.a /= Vec2Length(vector1);
            vector1.b /= Vec2Length(vector1);
            return vector1;
        }

        double Vec2Vec(Vector2 vector1, Vector2 vector2) {
            return vector1.a * vector2.a + vector1.b * vector2.b;
        }

    }

    static class Vector3 {
        int a;
        int b;
        int c;

        Vector3(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Vector3 Vec3Sum(Vector3 vector1, Vector3 vector2, char sym) {
            switch (sym) {
                case '+' -> {
                    vector1.a += vector2.a;
                    vector1.b += vector2.b;
                    vector1.c += vector2.c;
                }
                case '-' -> {
                    vector1.a -= vector2.a;
                    vector1.b -= vector2.b;
                    vector1.c -= vector2.c;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        Vector3 Vec3mult(Vector3 vector1, int num, char sym) {
            switch (sym) {
                case '*' -> {
                    vector1.a *= num;
                    vector1.b *= num;
                    vector1.c *= num;
                }
                case '/' -> {
                    vector1.a /= num;
                    vector1.b /= num;
                    vector1.c /= num;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        double Vec3Length(Vector3 vector1) {
            return Math.sqrt(vector1.a ^ 2 + vector1.b ^ 2 + vector1.c ^ 2);
        }

        Vector3 Vec3Norm(Vector3 vector1) {
            vector1.a /= Vec3Length(vector1);
            vector1.b /= Vec3Length(vector1);
            vector1.c /= Vec3Length(vector1);
            return vector1;
        }

        double Vec3Scal(Vector3 vector1, Vector3 vector2) {
            return vector1.a * vector2.a + vector1.b * vector2.b + vector1.c * vector2.c;
        }

        Vector3 Vec3MultVec(Vector3 vector1, Vector3 vector2) {
            Vector3 multVec = new Vector3(
                    vector1.b * vector2.c - vector1.c * vector2.b,
                    vector1.c * vector2.a - vector1.a * vector2.c,
                    vector1.a * vector2.b - vector1.b * vector2.a);
            return multVec;
        }
    }

    static class Vector4 {
        int a;
        int b;
        int c;
        int d;

        Vector4(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        Vector4 Vec4Sum(Vector4 vector1, Vector4 vector2, char sym) {
            switch (sym) {
                case '+' -> {
                    vector1.a += vector2.a;
                    vector1.b += vector2.b;
                    vector1.c += vector2.c;
                    vector1.d += vector2.d;
                }
                case '-' -> {
                    vector1.a -= vector2.a;
                    vector1.b -= vector2.b;
                    vector1.c -= vector2.c;
                    vector1.d -= vector2.d;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        Vector4 Vec4mult(Vector4 vector1, int num, char sym) {
            switch (sym) {
                case '*' -> {
                    vector1.a *= num;
                    vector1.b *= num;
                    vector1.c *= num;
                    vector1.d *= num;
                }
                case '/' -> {
                    vector1.a /= num;
                    vector1.b /= num;
                    vector1.c /= num;
                    vector1.d /= num;
                }
                default -> throw new IllegalArgumentException();
            }
            return vector1;
        }

        double Vec4Length(Vector4 vector1) {
            return Math.sqrt(vector1.a ^ 2 + vector1.b ^ 2 + vector1.c ^ 2);
        }

        Vector4 Vec4Norm(Vector4 vector1) {
            vector1.a /= Vec4Length(vector1);
            vector1.b /= Vec4Length(vector1);
            vector1.c /= Vec4Length(vector1);
            vector1.d /= Vec4Length(vector1);
            return vector1;
        }

        double Vec4Scal(Vector4 vector1, Vector4 vector2) {
            return vector1.a * vector2.a + vector1.b * vector2.b + vector1.c * vector2.c;
        }
    }
}