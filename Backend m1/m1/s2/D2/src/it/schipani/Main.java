package it.schipani;

import it.schipani.it.schipani.classes.Contatto;
import it.schipani.it.schipani.classes.Rubrica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        /*es1();*/
        /*List<Integer> numeriCasuali = orderdList(5);
        List<Integer> newNumeri = newList(numeriCasuali);
        log.info(newNumeri.toString());
        stampaNumeri(newNumeri, false);*/


        Rubrica r1 = new Rubrica();
        r1.addContatto(new Contatto("Antonio", 333333333));
        r1.addContatto(new Contatto("Cristiano", 44444444));
        r1.addContatto(new Contatto("Andrea", 666666666));
        r1.addContatto(new Contatto("Danilo", 55555555));
        log.info(String.valueOf(r1));
        r1.rimuoviContatto("Danilo");
        log.info(String.valueOf(r1));
        r1.searchByNum(33332333);
        r1.searchByName("Andrea");

    }

    public static void es1() {
        Set<String> arrParole = new HashSet<>();
        Set<String> arrParoleDuplicate = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        log.info("Inserisci un intero che rappresenti il numero di interi da inserire: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            log.info("Inserisci la " + (i + 1) + "° stringa:");
            String str = sc.nextLine();

            if (!arrParole.add(str)) {
                arrParoleDuplicate.add(str);
            } else {
                arrParole.add(str);
            }
        }
        sc.close();

        log.info("Parole duplicate: ");
        for (String parole : arrParoleDuplicate) {
            log.info(parole);
        }

        int numeroParoleDistinte = arrParole.size();
        log.info("Le parole distinte sono " + numeroParoleDistinte + ", e sono:");
        for (String p : arrParole) {
            log.info(p);
        }
    }

    /*ESERCIZIO 2*/
    public static List<Integer> orderdList(int n) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int randNum = rand.nextInt(101);
            list.add(randNum);
        }

        Collections.sort(list);
        return list;
    }

    public static List<Integer> newList(List<Integer> l) {

        List<Integer> oldArr = new ArrayList<>(l);
        Collections.shuffle(oldArr);
        List<Integer> newArr = new ArrayList<>(l);
        for (int n : oldArr) {
            newArr.add(n);
        }
        return newArr;
    }

    public static void stampaNumeri(List<Integer> l, boolean b){
        if (b){
            for (int i = 0; i < l.size(); i++){
                if(i % 2 == 0){
                    log.info(String.valueOf(l.get(i)));
                }
            }
        }else{
            int index = 0;
            for (Integer n : l){
                if (index % 2 != 0){
                    log.info(String.valueOf(n));
                }
                index++;
            }
        }
    }
}
