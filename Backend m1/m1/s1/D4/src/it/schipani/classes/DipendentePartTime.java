package it.schipani.classes;

public class DipendentePartTime extends Dipendente{
private int oreLavorative;

    public DipendentePartTime(int matricola, double stipendio, Dipartimento dipartimento, int oreLavorative) {
        super(matricola, stipendio, dipartimento);
        this.oreLavorative = oreLavorative;
    }

    @Override
    public void calculateSalary() {
        double stipendio =(getStipendio() / 27) / getOreLavorative();
        System.out.println("Il dipendente part-time con matricola: " + getMatricola() + ", ha uno stipendio orario di " + Math.round(stipendio * 100.0) / 100.0);

    }

    public int getOreLavorative() {
        return oreLavorative;
    }


}
