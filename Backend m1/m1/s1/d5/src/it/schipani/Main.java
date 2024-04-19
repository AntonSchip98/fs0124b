package it.schipani;

import it.schipani.it.schipani.classes.*;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        LettoreMultimediale lettore = new LettoreMultimediale();
    /*    RegistrtazioneAudio r1 = new RegistrtazioneAudio("r1", 5, 12);


        Video v1 = new Video("v1", 4, 6, 10);

        Immagine i1 = new Immagine(7, "i1");

        i1.alzaLuminosita();
        i1.abbassaLuminosita();
        i1.show();
*/
        /*Aggiunge gli elementi al lettore tramite console*/
        lettore.addElementToLettore();
        /*esegue l elemento tramite console inserendo un numero da 1-5, 0 per uscire*/
        lettore.eseguiElementiMultimediali();

    }


}
