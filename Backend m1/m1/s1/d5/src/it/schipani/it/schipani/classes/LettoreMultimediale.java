package it.schipani.it.schipani.classes;

import java.util.Scanner;

/*Questa classe mi serve per creare un lettore musiscale in grado di conteneri 5 elementi Multimediali, audio, video, immagine*/
public class LettoreMultimediale {

    private EM[] elementi;

    public LettoreMultimediale() {
        this.elementi = new ElementoMultimediale[5];
    }

/*questo metodo, mi permette di capire tramite console quale elemento multimediale sto cercando di inserire nel lettore*/
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
                    this.elementi[i] = new Immagine(luminosita, titolo);
                    break;
                case 2:
                    // Registrazione Audio
                    System.out.println("Inserisci la durata:");
                    int durata = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserisci il volume:");
                    int volume = sc.nextInt();
                    sc.nextLine();
                    this.elementi[i] = new RegistrtazioneAudio(titolo, durata, volume);
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
                    this.elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Tipo non valido.");
            }
        }

    }

    public  void eseguiElementiMultimediali() {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        do {
            System.out.println("Seleziona l'elemento da eseguire (1-5, 0 per uscire):");
            scelta = scanner.nextInt();
            if (scelta >= 1 && scelta <= 5) {
                this.elementi[scelta - 1].eseguiElemento();

            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
    public void eseguiElementInLettore(int index) {

        elementi[index].eseguiElemento();

    }

    public EM[] getElementi() {
        return elementi;
    }
}
