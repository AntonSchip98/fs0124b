package it.schipani.it.schipani.classes;

public class Immagine extends ElementoMultimediale {


    private int luminosita;


    public Immagine(int luminosita, String titolo) {
        super(titolo, 0);
        this.luminosita = luminosita >= 0 && luminosita <= 5 ? luminosita : 3;

    }

    /*versione play dell immagine*/
    public void show() {
        String showVisual = this.getTitolo() + " ";
        for (int i = 0; i < luminosita; i++) {
            showVisual += "*";
        }
        System.out.println(showVisual);
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
        show();
    }

}
