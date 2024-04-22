package it.schipani.it.schipani.classes;

public class isPlayable extends Elemento {
    protected int volume;
    protected int luminosita;
    protected int durata;

    protected isPlayable(String title, ElementiMultimediali el) {
        super(title, el);

    }

    /*Metodo per abbassare la luminosità del video di uno ad ogni chiamata*/
    public void abbassaLuminosita() {
        if (this instanceof Immagine || this instanceof Video) {
            if (luminosita > 0) {
                luminosita--;
                System.out.println("Volume abbassato a: " + luminosita);
            } else {
                System.out.println("Muto!");
            }
        }else{
            System.out.println("Non puoi usare questo metodo");
        }
    }

    /*Metodo per alzare la luminosità del video di uno ad ogni chiamata*/
    public void alzaLuminosita() {
        if (this instanceof Immagine || this instanceof Video) {
            if (luminosita < 5) {
                luminosita++;
                System.out.println("Volume alzato a: " + luminosita);
            } else {
                System.out.println("Volume al massimo!");
            }
        }else{
            System.out.println("Non puoi usare questo metodo");
        }

    }    /*Metodo per abbassare il volume della registrazione di uno ad ogni chiamata*/

    public void abassaVolume() {
        if (this instanceof Video || this instanceof Audio) {
            if (volume > 0) {
                volume--;
                System.out.println("Volume abbassato a: " + volume);
            } else {
                System.out.println("Muto!");
            }
        }else{
            System.out.println("Non puoi usare questo metodo");
        }
    }

    /*Metodo per alzare il volume della registrazione di uno ad ogni chiamata*/
    public void alzaVolume(int volume) {
        if (this instanceof Immagine || this instanceof Video) {
            if (volume < 10) {
                volume++;
                System.out.println("Volume alzato a: " + volume);
            } else {
                System.out.println("Volume al massimo!");
            }
        }else{
            System.out.println("Non puoi usare questo metodo");
        }
    }



    @Override
    public void playOrShow() {

    }
}
