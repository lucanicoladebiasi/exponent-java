package com.github.lucanicoladebiasi.exponent;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class LevenshteinDistance {

    public static class Matrix {

        private final int[][] matrix;

        private final String origin;

        private final String target;

        private Matrix(
                final int[][] matrix,
                @NotNull final String origin,
                @NotNull final String target
        ) {
            this.matrix = matrix;
            this.origin = origin;
            this.target = target;
        }

        private static int minimum(final int a, final int b, final int c) {
            int min = a;
            if (b < min) min = b;
            if (c < min) min = c;
            return min;
        }

        @Contract("_, _ -> new")
        public static @NotNull Matrix of(
                @NotNull final String origin,
                @NotNull final String target
        ) {
            final int originLength = origin.length();
            final int targetLength = target.length();
            final int[][] matrix = new int[originLength + 1][targetLength + 1];
            for (int i = 0; i <= originLength; i++) {
                matrix[i][0] = i;
            }
            for (int j = 0; j <= targetLength; j++) {
                matrix[0][j] = j;
            }
            for (int i = 1; i <= originLength; i++) {
                for (int j = 1; j <= targetLength; j++) {
                    if (origin.charAt(i - 1) == target.charAt(j - 1)) {
                        matrix[i][j] = matrix[i - 1][j - 1];
                    } else {
                        final int min = minimum(matrix[i][j - 1], matrix[i - 1][j], matrix[i - 1][j - 1]);
                        matrix[i][j] = min + 1;
                    }
                }
            }
            return new Matrix(matrix, origin, target);
        }

        public int distance() {
            return matrix[origin.length()][target.length()];
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("    ");
            for (int j = 1; j <= matrix.length; j ++) {
                sb.append(String.format("  %c", target.charAt(j - 1)));
            }
            sb.append("\n");
            for (int i = 0; i < matrix.length; i++) {
                if (i > 0) {
                    sb.append(origin.charAt(i - 1));
                } else
                    sb.append(" ");
                for (int j = 0; j < matrix[i].length; j++) {
                    sb.append(String.format(" %2d", matrix[i][j]));
                }
                if (i < matrix.length - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

    } //~ Matrix

    public static void main(String[] args) {
        Matrix matrix = Matrix.of("kitten", "sitting");
        System.out.println(matrix);
        System.out.println(matrix.distance());
    }

} //~ LevenshteinDistance
