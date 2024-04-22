package it.schipani.it.schipani.classes;

public class Immagine extends isPlayable {



    public Immagine(String title, ElementiMultimediali el, int luminosita) {
        super(title, el);
        if (el == ElementiMultimediali.IMMAGINE) {
            this.luminosita = luminosita;
        }
    }


    /*versione play dell immagine*/
    protected void show() {
        String showVisual = this.getTitolo() + " ";
        for (int i = 0; i < luminosita; i++) {
            showVisual += "*";
        }
        System.out.println(showVisual);
    }

    @Override
    public void playOrShow() {
        show();
    }


    @Override
    public String toString() {
        return "Immagine{" + super.toString() +
                "luminosita=" + luminosita +
                '}';
    }
}
