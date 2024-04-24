package it.schip;

import it.schip.it.schip.classes.NumException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.debug("Ciao");
        int[] arr = arrRand();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr(arr)));
    }

    public static int[] arrRand() {
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = new Random().nextInt(1, 11);
        }
        return arr;
    }

    public static int[] newArr(int[] oldArr) {
        Scanner scanner = new Scanner(System.in);
        int[] newArr = new int[5];

        while (true) {
            System.out.println("Inserisci una posizione nell'array (0 per terminare): ");
            int index;

            try{
                index = scanner.nextInt() - 1;
                if (index == -1) {
                    break;
                }
                if (index < 0 || index >= newArr.length) {
                    throw new NumException();
                }
            }catch (NumException e){
                log.error("L'index deve essere compreso tra 1 e 5");
                continue;
            }


            System.out.println("Inserisci un nuovo numero nella posizione " + (index + 1));
            int newNum;

            try{
               newNum = scanner.nextInt();
                if (newNum < 1 || newNum > 10) {
                    throw new NumException();
                }
            }catch (NumException e){
                log.error("Il numero deve essere compreso tra 1 e 10");
                continue;
            }
            for (int i = 0; i < 5; i++) {
                if (i == index) {
                    newArr[i] = newNum;
                } else {
                    newArr[i] = oldArr[i];
                }
            }
            System.out.println("Array aggiornato:" + Arrays.toString(newArr));
        }

        return newArr;
    }
}