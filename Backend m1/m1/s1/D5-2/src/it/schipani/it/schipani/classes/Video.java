package it.schipani.it.schipani.classes;

public class Video extends isPlayable {


    public Video(String title, ElementiMultimediali el, int durata, int volume, int luminosita) {
        super(title, el);
        if (el == ElementiMultimediali.VIDEO) {
            this.durata = durata;
            this.volume = volume >= 0 && volume <= 10 ? volume : 5;
            this.luminosita = luminosita >= 0 && luminosita <= 5 ? luminosita : 3;
        }
    }

    protected void play() {
        /*questo primo ciclo for mi permette di iterare il titolo un numero di volte pari alla durata della registrazione */
        for (int i = 0; i < durata; i++) {
            String playVisual = this.getTitolo() + " ";
            /*questo secondo ciclo, ci permette di concatenare ad ogni iterazione del primo ciclo, un numero di punti esclamativi pari al volume, al titolo*/
            for (int j = 0; j < volume; j++) {
                playVisual += "!";

            }
            for (int k = 0; k < luminosita; k++) {
                playVisual += "*";
            }
            /*stampiamo il risutalto di playVisual in console*/
            System.out.println(playVisual);
        }
    }

    @Override
    public void playOrShow() {
        play();
    }

   /* @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toString() {
        return "Video{" +
                "durata=" + durata +
                '}';
    }*/

    @Override
    public String toString() {
        return "Video{" + super.toString() +
                "durata=" + durata +
                ", luminosita=" + luminosita +
                ", volume=" + volume +
                '}';
    }
}
