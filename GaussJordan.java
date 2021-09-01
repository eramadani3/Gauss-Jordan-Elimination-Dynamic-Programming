public class GaussJordan {
    public static void main(String[] args) {
        float array[][] = {{1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 5, 1, 5, 1, 1, 1, 1, 0},
                {1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 0},
                {1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 0},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
                {11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
                {1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
                {1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 12},
                {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 10},
                {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 7},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        int n = array.length;

        gauss(array, n);
    }

    public static void gauss(float array[][], int n){
        int i, j , k =0;
        int c, m =0;

        for(i =0; i < n; i++){
            if(array[i][i] ==0) {
                c = 1;
                while ((i + c) < n && array[i + c][i] == 0) {
                    c++;

                for(j = i, k =0; k <= n; k++){
                    float temp = array[j][k];
                    array[j][k] = array[j + c][k];
                    array[j+c][k] = temp;
                }
            }

            for(j = 0; j < n; j++){
                if(i != j){
                    float p = array[j][i] / array[i][i];
                    for(k =0; k <= n; k++)
                        array[j][k] = array[j][k] - (array[i][k]) * p;
                    }
                }
            }
            System.out.println("Result: ");
            for(i = 0; i < n; i ++){
                System.out.println("x" + (i + 1) + " = " + array[i][n] / array[i][i]);
            }
        }
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
}
