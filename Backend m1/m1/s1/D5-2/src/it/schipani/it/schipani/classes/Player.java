package it.schipani.it.schipani.classes;

import java.util.Scanner;

public class Player {
    private PlayOrShow[] elementi;

    public Player() {
        this.elementi = new isPlayable[5];
    }

    /*questo metodo, mi permette di capire tramite console quale elemento multimediale sto cercando di inserire nel lettore e mi richiede i dati relative ad esso*/
    public void addElementToLettore() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di elemento multimediale (1=Immagine, 2=Registrazione Audio, 3=Video):");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.println("Inserisci il titolo:");
            String titolo = sc.nextLine();

            switch (type) {
                case 1:
                    // Immagine
                    System.out.println("Inserisci la luminosita:");
                    int luminosita = sc.nextInt();
                    sc.nextLine();
                    this.elementi[i] = new Immagine(titolo,ElementiMultimediali.IMMAGINE, luminosita);
                    break;
                case 2:
                    // Registrazione Audio
                    System.out.println("Inserisci la durata:");
                    int durata = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserisci il volume:");
                    int volume = sc.nextInt();
                    sc.nextLine();
                    this.elementi[i] = new Audio(titolo,ElementiMultimediali.AUDIO, durata, volume);
                    break;
                case 3:
                    // Video
                    System.out.println("Inserisci la durata:");
                    int durataVideo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserisci il volume:");
                    int volumeVideo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserisci la luminosita:");
                    int luminositaVideo = sc.nextInt();
                    sc.nextLine();
                    this.elementi[i] = new Video(titolo,ElementiMultimediali.VIDEO, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Tipo non valido.");
            }
        }

    }

    /* metodo per trovare un elemento nell'istanza lettoreMultimediale tramite console, inserendo un int compreso tra 1 e 5, 0 chiude lo scanner*/
    public  void eseguiElementiMultimediali() {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        do {
            System.out.println("Seleziona l'elemento da eseguire (1-5, 0 per uscire):");
            scelta = scanner.nextInt();
            if (scelta >= 1 && scelta <= 5) {
                this.elementi[scelta - 1].playOrShow();

            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }


    public PlayOrShow[] getElementi() {
        return elementi;
    }
}
