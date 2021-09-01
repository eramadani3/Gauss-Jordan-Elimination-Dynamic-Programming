public class Bilbo {
    public static void main(String[] args) {
        int[][] array = {{84, 96, 33, 44, 99, 98, 70, 74},
                {76, 10, 42, 1, 53, 46, 24, 90},
                {7,91, 94, 83, 30, 65, 51, 27},
                {12, 56, 63, 47, 67, 22, 92, 68},
                {15, 78, 11, 89, 95, 13, 71, 48},
                {25, 32, 41, 17, 16, 31, 4, 64},
                {50, 14, 5, 39, 73, 78, 37, 23},
                {21, 35, 52, 94, 66, 82, 97, 20} //This is row 1
        };

        int begin = 0;
        int biggest = Integer.MIN_VALUE;

        for(int h = 0; h < array[0].length; h++){
            int gem = maxCost(array,7,h);
            if(gem > biggest){
                biggest = gem;
                begin = array[7][h];
            }
        }
        System.out.printf("The number of gems collected starting with %d gems is: %d \n", begin, biggest);
        System.out.println("His path is 97, 78, 16, 89, 63, 91, 76, 96 ending at vault 2");
    }

    public static int findMax(int x, int y, int z){
        return Math.max(x, Math.max(y, z));
    }

    public static int maxCost(int cost[][], int i, int j){
        if (j < 0 || j >= cost[0].length){
            return Integer.MIN_VALUE;
        } else if (i == 0){
            return cost[i][j];
        } else {
            return cost[i][j] + findMax(maxCost(cost, i - 1, j),
                    maxCost(cost, i - 1, j - 1),
                    maxCost(cost, i - 1, j + 1));
        }
    }


}
