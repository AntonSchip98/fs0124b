package it.schipani.it.schipani.classes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubrica {
    private static final Logger log = LoggerFactory.getLogger(Rubrica.class);
    private Contatto[] contatti;

    public Rubrica() {
        this.contatti = new Contatto[20];
    }

    public void addContatto(Contatto newContatto) {
        for (int i = 0; i < this.contatti.length; i++) {
            if (this.contatti[i] == null) {
                this.contatti[i] = newContatto;
                return;
            }
        }
        log.error("La rubrica è piena");
    }

    public void rimuoviContatto(String nome) {
        String name = nome;
        for (int i = 0; i < this.contatti.length; i++) {
            if (this.contatti[i] != null && this.contatti[i].getContatto().containsKey(nome)) {
                this.contatti[i] = null;
                log.info("Contatto " + nome + " eliminato dall rubrica");
                return;
            }
        }
        log.error("Contatto non trovato nella rubrica");
    }

    public void searchByNum(int num) {
        boolean found = false;
        for (Contatto c : contatti) {
            if (c != null && c.getContatto().containsValue(num)) {
                log.info(String.valueOf(c));
                found = true;
            }
        }
        if (!found) {
            log.error("Contatto non trovato nella rubrica");
        }
    }

    public void searchByName(String name){
        boolean found = false;
        for (Contatto c : contatti){
            if (c != null && c.getContatto().containsKey(name)){
                log.info(String.valueOf(c));
                found = true;
            }
        }
        if (!found) {
            log.error("Contatto non trovato nella rubrica");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rubrica:\n");
        for (Contatto contatto : contatti) {
            if (contatto != null) {
                stringBuilder.append("\t").append(contatto.getContatto()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
