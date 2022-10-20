import java.util.ArrayList;
import java.io.IOException;


public class Main {
    static Integer[][] matrix;

   public static void main (String[] args){

        String filelocation = args[0];
        Matrix2 m = new Matrix2();
        try {
            m.readMatrix(filelocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        matrix = m.getMatrix();

        // We check if the matrix is a square
        if (m.getColCount() != m.getRowCount()) {
            System.out.println("Es ist nicht ein Quadrat!");
            System.exit(0);
        }

       // we check if a number is in the matrix multiple times
        ArrayList<Integer> ints = new ArrayList<>();
        for (Integer arr[] : matrix) {
            for (int index = 0; index < arr.length; index++) {
                if (ints.contains(arr[index])) {
                   System.out.println("Eine Zahl kommt mehr als einmal vor!");
                } else {
                    ints.add(arr[index]);

                }
            }


        }


        // we check rows
        Integer rowCounts [] = new Integer[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            int sumRow = 0;
            for(int j = 0; j < matrix.length; j++){
                sumRow = sumRow + matrix[i][j];
            }
        rowCounts[i] = sumRow;

        }

        // now we check columns
        Integer colCounts [] = new Integer[matrix.length];
        for (int i =0;i< matrix.length; i++){
            int sumCol = 0;
            for (int j = 0;j< matrix.length; j++){
                sumCol = sumCol + matrix[i][j];

            }

            colCounts[i] = sumCol;
        }



        // we check the diagonals next and compare all these numbers with each other
        Integer diagonalrechts [] = m.slice(0,m.getRowCount()-1,m.getRowCount()-1, 0);
        int sumdiagonalrechts = sumArray(diagonalrechts);
        Integer diagonallinks [] = m.slice(0,0,m.getColCount()-1,m.getRowCount()-1);
        int sumdiagonallinks = sumArray(diagonallinks);

        if ((sumdiagonallinks == sumdiagonalrechts)&&(rowCounts[0] == colCounts[0])&& (sumdiagonallinks == rowCounts[0])){
            System.out.println("Magic Square!");
        }else{
            System.out.println("Not a Magic Square!");
        }




    }
public static int sumArray (Integer [] x){
        int sum = 0;
        for (int a : x){
            sum += a;

        }

return sum; }

}


