public class ForwardElimination {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1},
                {1, 1, 2},
                {2, 2, 3}};
        int[] b = new int[] {6, 9, 15};
        System.out.println("1. Forward elimination fails to provide a solution for this matrix because has a row and column value ");
        System.out.println("Turned to 0, Since we cant pivot, the BetterForwardElimination helps this by making sure the pivot isn't 0 \n");
        System.out.println("2. Since the betterForwardElimination has infinite solutions the algorithm cannot complete.");
        betterForwardElimination(matrix,b);

    }


    public static void showMatrix(int[][] matrix){
        System.out.println("Matrix A: ");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void betterForwardElimination(int[][] A, int[] B){
        int len = A.length;
        int pivot = 0;

        for(int i = 0; i< len; i++){
            A[i][len] = B[i];
        }

        for(int i = 0; i < len -1; i++){
            pivot = i;
            showMatrix(A);
            for(int j =i +1; j < len; j++){
                if(A[j][i] > A[pivot][i]) pivot = j;
                System.out.printf("The new pivot row is %d", pivot);
                int temporary = (A[j][i]/ A[i][i]);

                for(int h = i; h < len +1; h++){
                    System.out.println("A[" + j + "][" + h + "] -= " + "A[" + i + "][" + h + "] * (A[" + j + "][" + i + "]/A[" + i + "][" + i + "])");
                    System.out.printf("%d = %d - (%d * (%d))",A[j][h], A[j][h], A[i][h], temporary);

                    A[j][h] = A[j][h] - (A[i][h] * temporary);
                }
            }
        }
    }
}
