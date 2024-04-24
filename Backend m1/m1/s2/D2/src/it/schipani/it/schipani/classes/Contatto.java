package it.schipani.it.schipani.classes;

import java.util.HashMap;
import java.util.Map;

public class Contatto {
    private Map<String, Integer> contatto;

    public Contatto(String name, int num) {
        this.contatto = new HashMap<>();
        this.contatto.put(name, num);


    }

    public Map<String, Integer> getContatto() {
        return contatto;
    }


    public void setContatto(Map<String, Integer> contatto) {
        this.contatto = contatto;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contatto = ");
        for (Map.Entry<String, Integer> entry : contatto.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()); // Rimuove l'ultima virgola e lo spazio aggiunti nella loop

        return stringBuilder.toString();
    }

}
