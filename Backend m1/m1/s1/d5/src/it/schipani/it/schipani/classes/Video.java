package it.schipani.it.schipani.classes;

public class Video extends RegistrtazioneAudio {

    private int luminosita;

    public Video(String titolo, int durata,int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita >= 0 && luminosita <= 5 ? luminosita : 3;
    }
    @Override
    public void play() {
        /*questo primo ciclo for mi permette di iterare il titolo un numero di volte pari alla durata della registrazione */
        for (int i = 0; i < getDurata(); i++) {
            String playVisual = getTitolo() + " ";
            /*questo secondo ciclo, ci permette di concatenare ad ogni iterazione del primo ciclo, un numero di punti esclamativi pari al volume, al titolo*/
            for (int j = 0; j < getVolume(); j++) {
                playVisual += "!";

            }
            for (int k = 0; k < luminosita; k++){
                playVisual += "*";
            }
            /*stampiamo il risutalto di playVisual in console*/
            System.out.println(playVisual);
        }
    }


    /*Metodo per abbassare la luminosità del video di uno ad ogni chiamata*/
    public void abbassaLuminosita() {
        if (luminosita > 0) {
            luminosita--;
            System.out.println("Volume abbassato a: " + luminosita);
        } else {
            System.out.println("Muto!");
        }
    }

    /*Metodo per alzare la luminosità del video di uno ad ogni chiamata*/
    public void alzaLuminosita() {
        if (luminosita < 5) {
            luminosita++;
            System.out.println("Volume alzato a: " + luminosita);
        } else {
            System.out.println("Volume al massimo!");
        }
    }

    @Override
    public void eseguiElemento() {
        play();
    }
}