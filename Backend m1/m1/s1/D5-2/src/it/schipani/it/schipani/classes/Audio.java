package it.schipani.it.schipani.classes;

public class Audio extends isPlayable {


    public Audio(String title, ElementiMultimediali el, int durata, int volume) {
        super(title, el);
        if (el == ElementiMultimediali.AUDIO) {
            this.durata = durata;
            this.volume = volume >= 0 && volume <= 10 ? volume : 5;
        }
    }

    protected void play() {
        /*questo primo ciclo for mi permette di iterare il titolo un numero di volte pari alla durata della registrazione */
        for (int i = 0; i < durata; i++) {
            String playVisual = getTitolo() + " ";
            /*questo secondo ciclo, ci permette di concatenare ad ogni iterazione del primo ciclo, un numero di punti esclamativi pari al volume, al titolo*/
            for (int j = 0; j < volume; j++) {
                playVisual += "!";
            }
            /*stampiamo il risutalto di playVisual in console*/
            System.out.println(playVisual);
        }
    }



    @Override
    public String toString() {
        return "Audio{" + super.toString() +
                "volume=" + volume +
                ", durata=" + durata +
                '}';
    }

    @Override
    public void playOrShow() {
        play();
    }
}
