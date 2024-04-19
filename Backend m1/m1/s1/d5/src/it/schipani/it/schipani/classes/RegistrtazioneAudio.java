package it.schipani.it.schipani.classes;

public class RegistrtazioneAudio extends ElementoMultimediale {

    private int volume;

    public RegistrtazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        /*ho fatto in modo che, il valore del volume non possa mai eccedere il range tra 0 e 10*/
        this.volume = volume >= 0 && volume <= 10 ? volume : 5;
    }


    public void play() {
        /*questo primo ciclo for mi permette di iterare il titolo un numero di volte pari alla durata della registrazione */
        for (int i = 0; i < getDurata(); i++) {
            String playVisual = getTitolo() + " ";
            /*questo secondo ciclo, ci permette di concatenare ad ogni iterazione del primo ciclo, un numero di punti esclamativi pari al volume, al titolo*/
            for (int j = 0; j < volume; j++) {
                playVisual += "!";
            }
            /*stampiamo il risutalto di playVisual in console*/
            System.out.println(playVisual);
        }
    }

    /*Metodo per abbassare il volume della registrazione di uno ad ogni chiamata*/
    public void abassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume abbassato a: " + volume);
        } else {
            System.out.println("Muto!");
        }
    }

    /*Metodo per alzare il volume della registrazione di uno ad ogni chiamata*/
    public void alzaVolume() {
        if (volume < 10) {
            volume++;
            System.out.println("Volume alzato a: " + volume);
        } else {
            System.out.println("Volume al massimo!");
        }

    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void eseguiElemento() {
        play();
    }
}

