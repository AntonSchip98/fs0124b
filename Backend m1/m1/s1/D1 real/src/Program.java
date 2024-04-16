

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String[] arr = {"ciao", "miao", "bau", "coccode", "bru"};
        System.out.println(Arrays.toString(insertInArr(arr, "cane")));
//System.out.println(concatString());
//System.out.println(perimeter());
//System.out.println(evenOrOdd());
        // System.out.println(trianglePerimeter());
    }

    public static int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public static String concat(String string, int num) {
        return string + num;
    }

    public static String[] insertInArr(String[] arr, String newString) {
        if (arr.length != 5) {
            throw new IllegalArgumentException("L'array deve contenere esattamente 5 elementi");
        }
        String[] newArr = {arr[0], arr[1], newString, arr[2], arr[3], arr[4]};

        return newArr;
    }

    public static String concatString() {
        Scanner scanner = new Scanner(System.in);
        String[] str = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Inserire la stringa numero " + (i + 1));
            str[i] = scanner.nextLine();
        }
        return str[0] + " " + str[1] + " " + str[2];
    }

    public static double perimeter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la base del rettangolo: ");
        double n1 = scanner.nextDouble();
        System.out.println("Inserisci l'altezza del rettangolo: ");
        double n2 = scanner.nextDouble();
        scanner.close();

        return (n1 + n2) * 2;
    }

    public static double trianglePerimeter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la lunghezza del primo lato: ");
        double n1 = scanner.nextDouble();
        System.out.println("Inserisci la lunghezza del secondo lato: ");
        double n2 = scanner.nextDouble();
        System.out.println("Inserisci la lunghezza del terzo lato: ");
        double n3 = scanner.nextDouble();
        scanner.close();

        double semiperimetro = (n1 + n2 + n3) / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - n1) * (semiperimetro - n2) * (semiperimetro - n3));
        return Math.round(area * 1000.0) / 1000.0;
    }

    public static int evenOrOdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
