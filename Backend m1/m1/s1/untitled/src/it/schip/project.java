package it.schip;

import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        /*System.out.println(stringaPariDispari("ciaoo"));*/
/*
        System.out.println(annoBisestile(2021));
*/
        /*System.out.println(swiiiitc((4)));*/
        whhile();
        /*countdown(10);*/



    }

    public static boolean stringaPariDispari(String str) {
        String[] arrStr = str.split("");
        if (arrStr.length % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean annoBisestile(int year) {

        boolean div4 = year % 4 == 0;
        boolean div100 = year % 100 == 0;
        boolean div400 = year % 400 == 0;

        if (div4 && !div100 || div400) {
            return true;

        } else {
            return false;
        }
    }

    public static String swiiiitc(int num){

        String numStr;

        switch (num){
            case 0:
                numStr = "zero";
                break;
            case 1:
                numStr = "uno";
                break;
            case 2:
                numStr = "due";
                break;
            case 3:
                numStr = "tre";
                break;
            default:
                numStr = "il numero non è compreso tra 0 e 3...";
                break;
        }
        return numStr;
    }

    public static void whhile(){
        Scanner scanner = new Scanner(System.in);
       String input;
       String newStr;


        while (true){
            System.out.println("Inserisci una stringa");
            input = scanner.nextLine();

            if (":q".equals(input)){
                System.out.println("Fine While.");
                break;
            }

            String[] chars = input.split("");
            newStr = String.join(",", chars);
            System.out.println(newStr);

        }


    }

    public static void countdown(int num){
        for (int i = num; i >= 0; i--){
            System.out.println(i);
        }
    }
}
