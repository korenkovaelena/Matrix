import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //хочу чтобы пользователь задал размеры матрицы
        int[][] matr = createMatrixOfZeroes();
        printMatr(matr);
        randomize(matr);
        printMatr(matr);
        printLineSums(matr);
        System.out.println("максимальный элемент =  "+maxNumber(matr));
        stringWithMaxNumber(matr);
        System.out.println("минимальный элемент =  "+minNumber(matr));
        stringWithoutMaxMinNumber(matr);
    }

    private static int[][] createMatrixOfZeroes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размеры матрицы");
        int[][] matr = getMatr(scan);
        return matr;
    }

    private static int[][] getMatr(Scanner scan) {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matr = new int[n][m];
        return matr;
    }

    public static void printMatr(int[][] matr)
    {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.printf(" %3d", matr[i][j]);
            }
            System.out.println();
        }
    }

    public static void randomize(int[][] matr)
    {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                Random rn = new Random();
                int randomNum = rn.nextInt(100) ;
                matr[i][j] = randomNum;
            }
        }
    }

    //подсчитать и вывести сумму элементов в каждой строке матрицы
    public static void printLineSums(int[][] matr)
    {
        for (int i = 0; i < matr.length; i++) {
            int s = 0;
            for (int j = 0; j < matr[i].length; j++) {
                s += matr[i][j];
            }
            System.out.println("сумма элементов строки "+i+" равна "+s);
        }
    }
    public static int maxNumber(int[][] matr)
    {int max = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (matr[i][j]>max)
                    max = matr[i][j];
            }
        }
        //System.out.println("максимальный элемент =  "+max);
        return max;
    }
    public static void stringWithMaxNumber(int[][] matr)
    {int max = maxNumber(matr);
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (matr[i][j] == max) {
                    System.out.println("максимальный элемент находится в строке  " + i);
                    System.out.println("столбец с максимальным элементом:");
                    for (int s = 0; s < matr.length; s++)
                        System.out.println(matr[s][j]);
                }
            }
        }
    }

    public static int minNumber(int[][] matr)
    {int min = 99;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (matr[i][j]<min)
                    min = matr[i][j];
            }
        }
        //System.out.println("минимальный элемент =  "+min);
        return min;
    }


    public static void stringWithoutMaxMinNumber(int[][] matr)
    {int max = maxNumber(matr);
        int min = minNumber(matr);
        int s;

        for (int i = 0; i < matr.length; i++) {
            int a =0;
            for (int j = 0; j < matr[i].length; j++) {
                if (matr[i][j] == max || matr[i][j] == min )
                    a = -1;
                else
                    s=i;
            }
            if (a != -1)
                System.out.println("строка без max и min элементов  "+i);
        }
    }
}